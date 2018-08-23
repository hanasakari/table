package cn.app.websocket.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import cn.app.controller.tableController;
import cn.app.controller.userController;
import cn.app.util.util;
import cn.app.websocket.MyWebSocket;
import cn.app.websocket.util.ApplicationContextRegister;

@Component(value = "cmdhandler")
@Scope("prototype")
public class cmdhandler {
    private ApplicationContext act = ApplicationContextRegister.getApplicationContext();

    util util = act.getBean(util.class);
    //获取cmd进行处理

    /**
     * 获取cmd并且进行中央处理
     *
     * @param cmd      收到的cmd指令
     * @param tokenmap 收到的服务器上所有登陆成功的token
     * @return
     */
    public String getcmd(String cmd, CopyOnWriteArraySet<String> tokenmap) {
        String ret = "";
        // cmd 处理成json
        JSONObject jsonObject = JSONObject.parseObject(cmd);
        //开始基础处理业务（登陆 注册 等等）
        System.out.println(tokenmap);
        switch (jsonObject.getString("cmd")) {
            case "createUser": //注册用户
                userController usercontroller = act.getBean(userController.class);
                String uname = jsonObject.getString("uname");
                String upwd = jsonObject.getString("upwd");
                String code = jsonObject.getString("code");
                if (!code.equals("123")) {
                    jsonObject = JSONObject.parseObject("{\"createUser\":0}");
                    return jsonObject.toString();
                }
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                ret = usercontroller.createUser(util.MD5(uname + upwd), uname, upwd, df.format(new Date()));
                break;
            case "loginUser"://登陆用户
                userController usercontroller1 = act.getBean(userController.class);
                uname = jsonObject.getString("uname");
                upwd = jsonObject.getString("upwd");
                ret = usercontroller1.loginUser(uname, upwd);
                break;
            case "createRole"://创建角色
                userController usercontroller2 = act.getBean(userController.class);
                String uid = jsonObject.getString("uid");
                String rolename = jsonObject.getString("rolename");
                ret = usercontroller2.createRole(uid, rolename);
                break;
        }
        if (ret != "") return ret;


        //过滤器 查看token认证。
        String token = jsonObject.getString("token");
        try {
            if (!tokenmap.contains(token) && !token.isEmpty()) {//如果没有内存匹配到token，直接停止以下功能供应
                //System.out.println("over");
                jsonObject = JSONObject.parseObject("{\"loginUser\":0}");
                return jsonObject.toString();
            }
        } catch (Exception e) {
            //System.out.println("over by try");
            jsonObject = JSONObject.parseObject("{\"loginUser\":0}");
            return jsonObject.toString();
        }


        //开始各种逻辑业务业务（登陆注册外的所有需要验证业务）
        System.out.println("验证通过了");
        switch (jsonObject.getString("cmd")) {
            case "createRole"://创建角色
                userController usercontroller2 = act.getBean(userController.class);
                String uid = jsonObject.getString("uid");
                String rolename = jsonObject.getString("rolename");
                ret = usercontroller2.createRole(uid, rolename);
                break;
            case "selectAllTable"://查询所有表格
                tableController tablecontroller = act.getBean(tableController.class);
                ret = tablecontroller.selectAllTable();
                break;

            case "createTable"://创建表格
                tablecontroller = act.getBean(tableController.class);
                String tablename = jsonObject.getString("tablename");
                String tabledesc = jsonObject.getString("tabledesc");
                ret = tablecontroller.createTable(tablename, tabledesc);
                break;
        }
        JSONObject succesjson = JSONObject.parseObject(ret);
        succesjson.put("loginUser", "1");
        return succesjson.toString();
    }
}
