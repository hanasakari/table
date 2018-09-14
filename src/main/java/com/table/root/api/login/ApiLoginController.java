package com.table.root.api.login;

import com.table.core.oauth2.OAuthService;
import com.table.util.DaoStic;
import com.table.util.IdGeneratorUtil;
import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ResponseType;
import org.apache.oltu.oauth2.common.utils.OAuthUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class ApiLoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ApiLoginService apiLoginService;
    @Autowired
    OAuthService oAuthService;
    @Autowired
    IdGeneratorUtil idGeneratorUtil;

    @RequestMapping(value = "createToken.json", method = RequestMethod.POST)
    public ResponseEntity createToken(@RequestParam("appId") String appId) {
        Map<String, Object> rtn = apiLoginService.createToken(appId);
        return new ResponseEntity<>(rtn, HttpStatus.OK);
    }

    @RequestMapping(value = "authorize.json", method = RequestMethod.GET)
    public ResponseEntity authorize(HttpServletRequest request) throws OAuthSystemException, URISyntaxException {
        try {
            //构建OAuth 授权请求
            OAuthAuthzRequest oauthRequest = new OAuthAuthzRequest(request);
            //检查传入的客户端id是否正确
            if (!oAuthService.checkClientId(oauthRequest.getClientId())) {
                OAuthResponse response = OAuthASResponse
                        .errorResponse(HttpServletResponse.SC_BAD_REQUEST)
                        .setError(OAuthError.TokenResponse.INVALID_CLIENT)
                        .setErrorDescription(DaoStic.INVALID_CLIENT_DESCRIPTION)
                        .buildJSONMessage();
                return new ResponseEntity<>(
                        response.getBody(), HttpStatus.valueOf(response.getResponseStatus()));
            }

            Subject subject = SecurityUtils.getSubject();
            //如果用户没有登录，跳转到登陆页面
            if (!subject.isAuthenticated()) {
                String loginName = request.getParameter("login_name");
                String password = request.getParameter("password");
                Map<String, Object> login = apiLoginService.login(loginName, password);
                if (login.get("code").equals(500)) {
                    return new ResponseEntity<>(login, HttpStatus.NOT_FOUND);
                }
            }

            String username = (String) subject.getPrincipal();
            //生成授权码
            String authorizationCode = null;
            //responseType目前仅支持CODE，另外还有TOKEN
            String responseType = oauthRequest.getParam(OAuth.OAUTH_RESPONSE_TYPE);
            if (responseType.equals(ResponseType.CODE.toString())) {
                OAuthIssuerImpl oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());
                authorizationCode = oauthIssuerImpl.authorizationCode();
                oAuthService.addAuthCode(authorizationCode, username);
            }
            //进行OAuth响应构建
            OAuthASResponse.OAuthAuthorizationResponseBuilder builder =
                    OAuthASResponse.authorizationResponse(request,
                            HttpServletResponse.SC_FOUND);
            //设置授权码
            builder.setCode(authorizationCode);
            //得到到客户端重定向地址
            String redirectURI = oauthRequest.getParam(OAuth.OAUTH_REDIRECT_URI);

            //构建响应
            final OAuthResponse response = builder.location(redirectURI).buildQueryMessage();
            //根据OAuthResponse返回ResponseEntity响应
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(new URI(response.getLocationUri()));
            return new ResponseEntity(headers, HttpStatus.valueOf(response.getResponseStatus()));
        } catch (OAuthProblemException e) {
            //出错处理
            String redirectUri = e.getRedirectUri();
            if (OAuthUtils.isEmpty(redirectUri)) {
                //告诉客户端没有传入redirectUri直接报错
                return new ResponseEntity<>(
                        "OAuth callback url needs to be provided by client!!!", HttpStatus.NOT_FOUND);
            }
            //返回错误消息（如?error=）
            final OAuthResponse response =
                    OAuthASResponse.errorResponse(HttpServletResponse.SC_FOUND)
                            .error(e).location(redirectUri).buildQueryMessage();
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(new URI(response.getLocationUri()));
            return new ResponseEntity(headers, HttpStatus.valueOf(response.getResponseStatus()));
        }
    }
    //将code替换成token
    @RequestMapping(value = "codeToToken.json", method = RequestMethod.GET)
    public ResponseEntity codeToToken(@RequestParam String code) {
        OAuthResponse response = null;

        if (!oAuthService.checkAuthCode(code)) {
            try {
                response = OAuthASResponse.errorResponse(HttpServletResponse.SC_BAD_REQUEST)
                        .setError(OAuthError.TokenResponse.INVALID_GRANT)
                        .setErrorDescription("error grant code")
                        .buildJSONMessage();
            } catch (OAuthSystemException e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>(response != null ? response.getBody() : null, HttpStatus.valueOf(response != null ? response.getResponseStatus() : 0));
    }

    @RequestMapping(value = "signIn.json", method = RequestMethod.GET)
    public ResponseEntity signIn(@RequestParam String loginName, @RequestParam String password) {
        return new ResponseEntity<>(apiLoginService.login(loginName, password), HttpStatus.OK);
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
