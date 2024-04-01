package com.arthur.learn.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import com.arthur.learn.mybatis.entity.Emp;

public interface CacheMapper {
    Emp getEmpById(@Param("eid") Integer eid);

    void insertEmp(@Param("emp")Emp emp);
}
