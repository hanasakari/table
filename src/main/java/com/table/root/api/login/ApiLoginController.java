package com.table.root.api.login;

import com.google.common.collect.Maps;
import com.table.core.oauth2.OAuthService;
import com.table.util.DaoStic;
import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuer;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.GrantType;
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

            // 检查客户端安全Key是否正确
            if(!oAuthService.checkClientSecret(oauthRequest.getClientSecret())){
                OAuthResponse response = OAuthASResponse.errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
                        .setError(OAuthError.TokenResponse.UNAUTHORIZED_CLIENT)
                        .setErrorDescription("客户端验证失败，如错误的client_id/client_secret")
                        .buildJSONMessage();
                return new ResponseEntity(response.getBody(), HttpStatus.valueOf(response.getResponseStatus()));
            }
            String authCode = oauthRequest.getParam(OAuth.OAUTH_CODE);

            // 检查验证类型，此处只检查AUTHORIZATION类型，其他的还有PASSWORD或者REFRESH_TOKEN
            if(oauthRequest.getParam(OAuth.OAUTH_GRANT_TYPE).equals(GrantType.AUTHORIZATION_CODE.toString())){
                if(!oAuthService.checkAuthCode(authCode)){
                    OAuthResponse response = OAuthASResponse.errorResponse(HttpServletResponse.SC_BAD_REQUEST)
                            .setError(OAuthError.TokenResponse.INVALID_GRANT)
                            .setErrorDescription("error grant code")
                            .buildJSONMessage();
                    return new ResponseEntity(response.getBody(),HttpStatus.valueOf(response.getResponseStatus()));
                }
            }

            //生成Access Token
            OAuthIssuer issuer = new OAuthIssuerImpl(new MD5Generator());
            final String accessToken  = issuer.accessToken();
            oAuthService.addAccessToken(accessToken, oAuthService.getUsernameByAuthCode(authCode));

            // 生成OAuth响应
            OAuthResponse response = OAuthASResponse.tokenResponse(HttpServletResponse.SC_OK)
                    .setAccessToken(accessToken).setExpiresIn(String.valueOf(oAuthService.getExpireIn()))
                    .buildJSONMessage();

            return new ResponseEntity(response.getBody(),HttpStatus.valueOf(response.getResponseStatus()));
        } catch (OAuthSystemException | OAuthProblemException e) {
            e.printStackTrace();
            OAuthResponse res = OAuthASResponse.errorResponse(HttpServletResponse.SC_BAD_REQUEST).error(e).buildBodyMessage();
            return new ResponseEntity(res.getBody(),HttpStatus.valueOf(res.getResponseStatus()));
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
