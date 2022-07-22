package com.luopc1218.luopc1218server.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUpBody {
    private String username;
    private String password;
    private String avatar;
    private String checkPassword;
    private String email;
    private String phone;
    private Integer telCodeId;
}
