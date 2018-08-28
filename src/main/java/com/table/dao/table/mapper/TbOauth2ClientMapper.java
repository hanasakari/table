package com.table.dao.table.mapper;

import com.table.dao.table.entity.TbOauth2Client;
import com.table.dao.table.entity.TbOauth2ClientExample;
import org.springframework.stereotype.Repository;

/**
 * TbOauth2ClientMapper继承基类
 */
@Repository
public interface TbOauth2ClientMapper extends MyBatisBaseMapper<TbOauth2Client, String, TbOauth2ClientExample> {
}