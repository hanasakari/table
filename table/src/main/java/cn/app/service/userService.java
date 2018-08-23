package cn.app.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.app.dao.userDao;

@Service
public class userService {

    @Autowired
    public userDao userdao;


    public int createUser(String uid, String uname, String upwd, String regtime) {

        int result = userdao.createUser(uid, uname, upwd, regtime);
        return result;
    }

    public int loginUser(String uname, String upwd) {

        int result = userdao.loginUser(uname, upwd);
        return result;
    }

    public int createRole(String uid, String rolename) {
        //
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        int result = userdao.createRole(uid, rolename, df.format(new Date()), "50");
        return result;
    }

}
