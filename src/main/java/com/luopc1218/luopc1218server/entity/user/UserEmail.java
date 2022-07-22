package com.luopc1218.luopc1218server.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class UserEmail {
    private Integer id;
    private Integer userId;
    private String address;
    private Timestamp createTime;

    public UserEmail(Integer userId, String address) {
        this.userId = userId;
        this.address = address;
    }
}
