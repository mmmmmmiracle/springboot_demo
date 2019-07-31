package com.hyd.mercury.dao;

import com.hyd.mercury.entity.Material;

public interface MaterialMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Material record);

    int insertSelective(Material record);

    Material selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);
}