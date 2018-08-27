package com.table.root.api.login;

import com.google.common.collect.Maps;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class ApiLoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "signIn.json", method = RequestMethod.POST)
    public ResponseEntity signIn(@RequestParam String loginName, @RequestParam String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
        Map<String, Object> rtn = Maps.newHashMap();
        try {
            subject.login(token);
            rtn.put("loginName", loginName);
            rtn.put("session", token);
        } catch (AuthenticationException e) {
            logger.error("登陆错误,Id:" + loginName);
            rtn.put("loginName", loginName);
            rtn.put("session", false);
        }
        return new ResponseEntity<>(rtn, HttpStatus.OK);
    }

    @RequestMapping("signUp.json")
    public Object signUp() {
        return null;
    }

    @RequestMapping("signOut.json")
    public Object signOut() {
        return null;
    }
}
