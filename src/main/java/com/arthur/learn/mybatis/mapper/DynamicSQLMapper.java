package com.arthur.learn.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.arthur.learn.mybatis.entity.Emp;

public interface DynamicSQLMapper {
    
    List<Emp> getEmpByCondition(Emp emp);

    // Test choose/when/otherwise tags
    List<Emp> getEmpByChoose(Emp emp);

    // Batch delete
    int deleteMoreByArray(@Param("eids")Integer[] eids);

    // Batch insert
    int insertMoreByList(@Param("emps") List<Emp> emps);
}
