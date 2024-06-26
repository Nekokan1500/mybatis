package com.arthur.learn.mybatis.mapper;

import com.arthur.learn.mybatis.entity.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    Dept getDeptById(@Param("did")Integer did);

    Dept getDeptAndEmps(@Param("did")Integer did);

    Dept getDeptAndEmpsStepOne(@Param("did")Integer did);

}
