package com.arthur.learn.mybatis.mapper;

import com.arthur.learn.mybatis.entity.User;

public interface UserMapper {

    int insertUser();

    User getUserById(Integer id);
    
}
