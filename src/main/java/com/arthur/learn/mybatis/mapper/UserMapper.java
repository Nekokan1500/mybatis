package com.arthur.learn.mybatis.mapper;

import java.util.List;

import com.arthur.learn.mybatis.entity.User;

//import com.arthur.learn.mybatis.entity.User;

public interface UserMapper {

    int insertUser();
    int updateUser();
    int deleteUser();

    User getUserById();
    List<User> getAllUser();
}
