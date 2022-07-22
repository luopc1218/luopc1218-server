package com.luopc1218.luopc1218server.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class UserPhone {

    private Integer id;
    private Integer userId;
    private Integer telCodeId;
    private String phone;
    private Timestamp createTime;

    public UserPhone(Integer userId, Integer telCodeId, String phone) {
        this.userId = userId;
        this.telCodeId = telCodeId;
        this.phone = phone;
    }
}
