package com.arthur.learn.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.arthur.learn.mybatis.entity.User;

public interface SelectMapper {

    User getUserById(@Param("id") Integer id);
    List<User> getAllUsers();
}
