package com.luopc1218.luopc1218server.entity.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetUserInfoResponse extends User {
    private String telCode;
    private String phone;
    private String email;
    private Integer articleCount;
}
