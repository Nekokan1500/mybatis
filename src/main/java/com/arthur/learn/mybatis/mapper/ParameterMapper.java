package com.arthur.learn.mybatis.mapper;

import java.util.List;

import com.arthur.learn.mybatis.entity.User;

public interface ParameterMapper {

    List<User> getAllUsers();
    User getUserById(int id);
    User checkLogin(String name, String password);
}
