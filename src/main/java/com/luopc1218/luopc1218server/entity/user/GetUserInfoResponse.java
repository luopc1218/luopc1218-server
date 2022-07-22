package com.luopc1218.luopc1218server.entity.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetUserInfoResponse extends User {
    private String telCode;
    private String phone;
    private String email;

    public GetUserInfoResponse(Integer id, String name, String avatarUrl, Date createTime, String telCode, String phone, String email) {
        super(id, name, avatarUrl, createTime);
        this.telCode = telCode;
        this.phone = phone;
        this.email = email;
    }
}
