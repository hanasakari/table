package com.table.root.api.login;

import com.google.common.collect.Maps;
import com.table.dao.table.entity.TbOauth2Client;
import com.table.dao.table.entity.TbOauth2ClientExample;
import com.table.dao.table.mapper.TbOauth2ClientMapper;
import com.table.util.IdGeneratorUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ApiLoginService {
    @Autowired
    TbOauth2ClientMapper tbOauth2ClientMapper;
    @Autowired
    IdGeneratorUtil idGeneratorUtil;

    public Map<String, Object> createToken(String appId) {
        Map<String, Object> rtn = Maps.newHashMap();
        TbOauth2ClientExample tbOauth2ClientExample = new TbOauth2ClientExample();
        tbOauth2ClientExample.createCriteria().andTbOauth2ClientNameEqualTo(appId);
        List<TbOauth2Client> tbOauth2ClientList = tbOauth2ClientMapper.selectByExample(tbOauth2ClientExample);
        if (CollectionUtils.isEmpty(tbOauth2ClientList)) {
            String id = idGeneratorUtil.UUIDGenerator();
            String clientId = idGeneratorUtil.UUIDGenerator();
            String clientSecret = idGeneratorUtil.UUIDGenerator();
            TbOauth2Client tbOauth2Client = new TbOauth2Client();
            tbOauth2Client.setTbOauth2Id(id);
            tbOauth2Client.setTbOauth2ClientId(clientId);
            tbOauth2Client.setTbOauth2ClientName(appId);
            tbOauth2Client.setTbOauth2ClientSecret(clientSecret);
            tbOauth2ClientMapper.insert(tbOauth2Client);
            rtn.put("clientName", appId);
            rtn.put("clientId", clientId);
            rtn.put("clientSecret", clientSecret);
            rtn.put("code", 200);
        } else {
            rtn.put("message", "id is existed");
            rtn.put("code", 500);
        }
        return rtn;
    }
}
