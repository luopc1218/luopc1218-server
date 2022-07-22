package com.luopc1218.luopc1218server.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class UserPassword {
    private Integer id;
    private Integer userId;
    private String password;
    private Timestamp createTime;

    public UserPassword(Integer userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
