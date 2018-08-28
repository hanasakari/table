package com.table.root.api.login;

import com.google.common.collect.Maps;
import com.table.core.oauth2.OAuthService;
import com.table.util.DaoStic;
import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class ApiLoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ApiLoginService apiLoginService;
    @Autowired
    OAuthService oAuthService;

    @RequestMapping(value = "signIn.json", method = RequestMethod.GET)
    public ResponseEntity signIn(HttpServletRequest request) {
        //获取oauthRequest
        try {
            OAuthTokenRequest oauthRequest = new OAuthTokenRequest(request);
            if (!oAuthService.checkClientId(oauthRequest.getClientId())) {
                OAuthResponse response =
                        OAuthASResponse.errorResponse(HttpServletResponse.SC_BAD_REQUEST)
                                .setError(OAuthError.TokenResponse.INVALID_CLIENT)
                                .setErrorDescription(DaoStic.INVALID_CLIENT_DESCRIPTION)
                                .buildJSONMessage();
                return new ResponseEntity<>(response.getBody(), HttpStatus.valueOf(response.getResponseStatus()));
            }
        } catch (OAuthSystemException | OAuthProblemException e) {
            e.printStackTrace();
        }
        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
        Map<String, Object> rtn = Maps.newHashMap();
        try {
//            subject.login(token);
//            rtn.put("loginName", loginName);
            rtn.put("session", subject.getSession());
        } catch (AuthenticationException e) {
//            logger.error("登陆错误,Id:" + loginName);
//            rtn.put("loginName", loginName);
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
