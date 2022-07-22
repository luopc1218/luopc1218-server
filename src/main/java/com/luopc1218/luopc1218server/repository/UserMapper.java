package com.luopc1218.luopc1218server.repository;

import com.luopc1218.luopc1218server.entity.user.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User getUserById(Integer id);

    User getUserByName(String name);

    String getUserPassword(Integer userId);

    void addUser(@Param("user") User user);

    void addUserPassword(@Param("userPassword") UserPassword userPassword);

    void changeAvatar(Integer id, String avatarUrl);

    void changePassword(Integer userId, String newPassword);

    void addUserPhone(@Param("userPhone") UserPhone userPhone);

    void addUserEmail(@Param("userEmail") UserEmail userEmail);

    GetUserInfoResponse getUserInfo(Integer id);
}
