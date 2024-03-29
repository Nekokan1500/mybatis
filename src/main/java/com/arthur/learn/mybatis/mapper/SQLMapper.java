package com.arthur.learn.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.arthur.learn.mybatis.entity.User;

public interface SQLMapper {

    List<User> getUserByLike(@Param("name")String name);

    int deleteUsers(@Param("ids")String ids);

    List<User> getUsersByTableName(@Param("tableName")String tableName);

    void insertUser(User user);
    
}
