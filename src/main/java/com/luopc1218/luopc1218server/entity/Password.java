package com.luopc1218.luopc1218server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.DigestUtils;

@Data
@AllArgsConstructor
public class Password {
    private String password;

    public String getEncryptedPassword() {
        return DigestUtils.md5DigestAsHex(this.password.getBytes());
    }
}
