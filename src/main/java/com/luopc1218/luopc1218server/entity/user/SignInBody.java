package com.luopc1218.luopc1218server.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignInBody {
    private String username;
    private String password;
}
