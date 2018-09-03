package com.table.root.api.login;

import com.table.dao.table.entity.TbOauth2Client;
import com.table.dao.table.entity.TbOauth2ClientExample;
import com.table.dao.table.mapper.TbOauth2ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiLoginService {
    @Autowired
    TbOauth2ClientMapper tbOauth2ClientMapper;
    public Boolean checkAtouhName(String appId){
        TbOauth2ClientExample tbOauth2ClientExample = new TbOauth2ClientExample();
        tbOauth2ClientExample.createCriteria().andTbOauth2ClientNameEqualTo(appId);
        List<TbOauth2Client> tbOauth2ClientList = tbOauth2ClientMapper.selectByExample(tbOauth2ClientExample);
        return tbOauth2ClientList.size() == 0;
    }
}
