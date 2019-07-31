package com.hyd.mercury.dao;

import com.hyd.mercury.entity.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}