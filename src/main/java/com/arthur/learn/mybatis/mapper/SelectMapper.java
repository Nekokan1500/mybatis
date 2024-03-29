package com.arthur.learn.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.arthur.learn.mybatis.entity.User;

public interface SelectMapper {

    User getUserById(@Param("id") Integer id);

    List<User> getAllUsers();

    Integer getUserCount();

    Map<String, Object> getUserByIdToMap(@Param("id")Integer id);

    List<Map<String, Object>> getAllUsersToMap();

    @MapKey("id")
    Map<String, Object> getAllUsersToMap2();
}
