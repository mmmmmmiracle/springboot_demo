package com.hyd.mercury.dao;

import com.hyd.mercury.entity.AuthorityPositionRelation;

public interface AuthorityPositionRelationMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(AuthorityPositionRelation record);

    int insertSelective(AuthorityPositionRelation record);

    AuthorityPositionRelation selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(AuthorityPositionRelation record);

    int updateByPrimaryKeyWithBLOBs(AuthorityPositionRelation record);

    int updateByPrimaryKey(AuthorityPositionRelation record);
}