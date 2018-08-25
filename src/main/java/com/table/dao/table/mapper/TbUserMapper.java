package com.table.dao.table.mapper;

import com.table.dao.table.entity.TbUser;
import com.table.dao.table.entity.TbUserExample;
import org.springframework.stereotype.Repository;

/**
 * TbUserMapper继承基类
 */
@Repository
public interface TbUserMapper extends MyBatisBaseMapper<TbUser, String, TbUserExample> {
}