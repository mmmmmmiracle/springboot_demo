package com.hyd.mercury.dao;

import com.hyd.mercury.entity.Position;

public interface PositionMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
}