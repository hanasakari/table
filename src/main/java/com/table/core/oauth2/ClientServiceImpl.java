package com.table.core.oauth2;

import com.table.dao.table.entity.TbOauth2Client;
import com.table.dao.table.entity.TbOauth2ClientExample;
import com.table.dao.table.mapper.TbOauth2ClientMapper;
import com.table.util.IdGeneratorUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    TbOauth2ClientMapper tbOauth2ClientMapper;
    @Autowired
    IdGeneratorUtil idGeneratorUtil;

    @Override
    public TbOauth2Client createClient(TbOauth2Client tbOauth2Client) {

        tbOauth2Client.setTbOauth2Id(idGeneratorUtil.UUIDGenerator());
        tbOauth2Client.setTbOauth2ClientId(idGeneratorUtil.UUIDGenerator());
        tbOauth2Client.setTbOauth2ClientSecret(idGeneratorUtil.UUIDGenerator());
        tbOauth2ClientMapper.insertSelective(tbOauth2Client);
        return tbOauth2Client;
    }

    @Override
    public TbOauth2Client updateClient(TbOauth2Client tbOauth2Client) {
        tbOauth2ClientMapper.updateByPrimaryKeySelective(tbOauth2Client);
        return tbOauth2Client;
    }

    @Override
    public void deleteClient(String clientId) {
        tbOauth2ClientMapper.deleteByPrimaryKey(clientId);
    }

    @Override
    public TbOauth2Client findOne(String clientId) {
        return tbOauth2ClientMapper.selectByPrimaryKey(clientId);
    }

    @Override
    public List<TbOauth2Client> findAll() {
        TbOauth2ClientExample tbOauth2ClientExample = new TbOauth2ClientExample();
        return tbOauth2ClientMapper.selectByExample(tbOauth2ClientExample);
    }

    @Override
    public TbOauth2Client findByClientId(String clientId) {
        TbOauth2ClientExample tbOauth2ClientExample = new TbOauth2ClientExample();
        tbOauth2ClientExample.createCriteria().andTbOauth2ClientIdEqualTo(clientId);
        List<TbOauth2Client> tbOauth2Clients = tbOauth2ClientMapper.selectByExample(tbOauth2ClientExample);
        if (CollectionUtils.isNotEmpty(tbOauth2Clients))
            return tbOauth2Clients.get(0);
        else
            return new TbOauth2Client();
    }

    @Override
    public TbOauth2Client findByClientSecret(String clientSecret) {
        TbOauth2ClientExample tbOauth2ClientExample = new TbOauth2ClientExample();
        tbOauth2ClientExample.createCriteria().andTbOauth2ClientSecretEqualTo(clientSecret);
        List<TbOauth2Client> tbOauth2Clients = tbOauth2ClientMapper.selectByExample(tbOauth2ClientExample);
        if (CollectionUtils.isNotEmpty(tbOauth2Clients))
            return tbOauth2Clients.get(0);
        else
            return new TbOauth2Client();
    }
}
