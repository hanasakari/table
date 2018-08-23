package cn.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;

import cn.app.service.userService;
import cn.app.util.util;
import cn.app.websocket.util.ApplicationContextRegister;

@Controller(value = "userController")
@Scope("prototype")
public class userController {
    @Autowired
    public userService userservice;
    private ApplicationContext act = ApplicationContextRegister.getApplicationContext();
    util util = act.getBean(util.class);

    /**
     * 创建用户
     *
     * @param uid
     * @param uname
     * @param upwd
     * @param regtime
     * @return
     */
    public String createUser(String uid, String uname, String upwd, String regtime) {
        //{\"createUser\":0}
        JSONObject jsonObject = JSONObject.parseObject("{\"createUser\":" + userservice.createUser(uid, uname, upwd, regtime) + "}");
        jsonObject.put("touser", "self");
        return jsonObject.toString();
    }

    /**
     * 登陆用户
     *
     * @param uname
     * @param upwd
     * @return
     */
    public String loginUser(String uname, String upwd) {
        //{\"loginUser\":0}
        int result = userservice.loginUser(uname, upwd);
        JSONObject jsonObject = JSONObject.parseObject("{\"loginUser\":" + result + "}");
        jsonObject.put("touser", "selfAndhandler");
        if (result > 0) {//如果登陆成功返回token
            jsonObject.put("token", util.MD5(uname + upwd));
        }
        return jsonObject.toString();
    }

    /**
     * 登陆用户
     *
     * @param uname
     * @param upwd
     * @return
     */
    public String createRole(String uid, String rolename) {
        //{\"createRole\":0}
        int result = userservice.createRole(uid, rolename);
        JSONObject jsonObject = JSONObject.parseObject("{\"createRole\":" + result + "}");
        jsonObject.put("touser", "self");
        return jsonObject.toString();
    }


}
