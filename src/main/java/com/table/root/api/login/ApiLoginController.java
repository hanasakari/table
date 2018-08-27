package com.table.root.api.login;

import com.google.common.collect.Maps;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class ApiLoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired

    @RequestMapping(value = "getAuth.json",method = RequestMethod.GET)
    public ResponseEntity auth(HttpServletRequest request){
        Map<String, Object> rtn = Maps.newHashMap();
        try {
            OAuthAuthzRequest oauthRequest = new OAuthAuthzRequest(request);
            if (!oAuthService.checkClientId(oauthRequest.getClientId())) {
                OAuthResponse response = OAuthASResponse
                        .errorResponse(HttpServletResponse.SC_BAD_REQUEST)
                        .setError(OAuthError.TokenResponse.INVALID_CLIENT)
                        .setErrorDescription(Constants.INVALID_CLIENT_DESCRIPTION)
                        .buildJSONMessage();
                return new ResponseEntity(
                        response.getBody(), HttpStatus.valueOf(response.getResponseStatus()));
            }
        } catch (OAuthSystemException e) {
            e.printStackTrace();
        } catch (OAuthProblemException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(rtn,HttpStatus.OK);
    }

    @RequestMapping(value = "signIn.json", method = RequestMethod.GET)
    public ResponseEntity signIn(@RequestParam String loginName, @RequestParam String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
        Map<String, Object> rtn = Maps.newHashMap();
        try {
            subject.login(token);
            rtn.put("loginName", loginName);
            rtn.put("session", subject.getSession());
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
