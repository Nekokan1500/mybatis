package com.arthur.learn.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.arthur.learn.mybatis.entity.User;

public interface ParameterMapper {

    List<User> getAllUsers();

    User getUserById(int id);

    User checkLogin(String name, String password);

    User checkLoginByMap(Map<String, Object> map);

    int insertUser(User user);

    User checkLoginByParam(@Param("name")String name, @Param("password")String password);
}
