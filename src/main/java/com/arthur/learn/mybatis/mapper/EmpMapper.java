package com.arthur.learn.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.arthur.learn.mybatis.entity.Emp;


public interface EmpMapper {

    List<Emp> getAllEmps();

    // use ResultMap
    List<Emp> getAllEmps2();

    Emp getEmpAndDept(@Param("eid")Integer eid);

    //  Step-wise query
    // step1: get emp by eid
    Emp getEmpAndDeptByStepOne(@Param("eid")Integer eid);
}
