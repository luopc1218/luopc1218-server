package com.luopc1218.luopc1218server.entity.user;

import lombok.Data;

import java.util.Date;

@Data
public class GetUserInfoResponse  {
    private Integer id;
    private String name;
    private String avatarUrl;
    private Date createTime;
    private String telCode;
    private String phone;
    private String email;
    private Integer articleCount;
    private String groupName;
    private Integer groupType;
}
