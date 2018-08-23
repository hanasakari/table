package cn.app.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import cn.app.websocket.controller.cmdhandler;
import cn.app.websocket.util.ApplicationContextRegister;

@ServerEndpoint("/my-websocket")
@Component
public class MyWebSocket {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static int onlineCount = 0;
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<>();
    private Session session;
    private ApplicationContext act = ApplicationContextRegister.getApplicationContext();
    private static CopyOnWriteArraySet<String> tokenmap = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) throws IOException {

        this.session = session;
        webSocketSet.add(this);
        incrOnlineCount();
        for (MyWebSocket item : webSocketSet) {
            if (!item.equals(this)) { //变量后只发给别人
                item.sendMessage("某人刚刚加入了连接.");
            }
        }
        logger.info("新连接加入...现在在线人数 : {}", getOnlineCount());
    }

    @OnClose
    public void onClose() throws IOException {
        try {
            tokenmap.remove(this);
        } catch (Exception e) {

        }
        webSocketSet.remove(this);
        decOnlineCount();
        for (MyWebSocket item : webSocketSet) {
            item.sendMessage("某人刚刚关闭了连接.");
        }
        logger.info("一个连接关闭了...现在在线人数: {}", getOnlineCount());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {

        logger.info("收到信息: {}", message);
        cmdhandler cmdhandler = act.getBean(cmdhandler.class);
        String retcmd = cmdhandler.getcmd(message, tokenmap);
        try {
            JSONObject jsonObject = JSONObject.parseObject(retcmd);
            System.out.println(jsonObject.toString());
            switch (jsonObject.getString("touser")) {
                case "self"://发送给自己
                    for (MyWebSocket item : webSocketSet) {
                        item.sendMessage(jsonObject.toJSONString());
                    }
                    break;

                case "other"://发送给他人
                    for (MyWebSocket item : webSocketSet) {
                        if (!item.equals(this)) { //变量后只发给别人
                            item.sendMessage(jsonObject.toJSONString());
                        }
                    }
                    break;

                case "all":
                    // 广播收到的消息
                    for (MyWebSocket item : webSocketSet) {
                        item.sendMessage(jsonObject.toJSONString());
                    }
                    break;
                case "selfAndhandler"://自己和中心处理器

                    if (jsonObject.getString("loginUser").equals("1")) {//登陆成功增加token到内存中。
                        //System.out.println("增加了token"+jsonObject.getString("token"));
                        tokenmap.add(jsonObject.getString("token"));
                    }
                    for (MyWebSocket item : webSocketSet) {
                        item.sendMessage(jsonObject.toJSONString());
                    }
                    break;

                default:
                    break;
            }
        } catch (Exception e) {

        }

    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return MyWebSocket.onlineCount;
    }

    public static synchronized void incrOnlineCount() {
        MyWebSocket.onlineCount++;
    }

    public static synchronized void decOnlineCount() {
        MyWebSocket.onlineCount--;
    }
}
