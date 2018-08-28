package com.table.core.oauth2;

import com.table.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OAuthServiceImpl implements OAuthService{

    @Autowired
    private ClientService clientService;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void addAuthCode(String authCode, String username) {
        redisUtil.add(authCode, username);
    }

    @Override
    public void addAccessToken(String accessToken, String username) {
        redisUtil.add(accessToken, username);
    }

    @Override
    public String getUsernameByAuthCode(String authCode) {
        try {
            return redisUtil.get(authCode).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getUsernameByAccessToken(String accessToken) {
        try {
            return redisUtil.get(accessToken).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean checkAuthCode(String authCode) {
        try {
            return redisUtil.get(authCode) != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean checkAccessToken(String accessToken){
        try {
            return redisUtil.get(accessToken) != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean checkClientId(String clientId) {
        return clientService.findByClientId(clientId) != null;
    }

    @Override
    public boolean checkClientSecret(String clientSecret) {
        return clientService.findByClientSecret(clientSecret) != null;
    }

    @Override
    public long getExpireIn() {
        return 3600L;
    }
}
