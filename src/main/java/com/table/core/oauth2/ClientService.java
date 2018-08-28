package com.table.core.oauth2;

import com.table.dao.table.entity.TbOauth2Client;

import java.util.List;

public interface ClientService {

    public TbOauth2Client createClient(TbOauth2Client client);
    public TbOauth2Client updateClient(TbOauth2Client client);
    public void deleteClient(String clientId);

    TbOauth2Client findOne(String clientId);

    List<TbOauth2Client> findAll();

    TbOauth2Client findByClientId(String clientId);
    TbOauth2Client findByClientSecret(String clientSecret);
}
