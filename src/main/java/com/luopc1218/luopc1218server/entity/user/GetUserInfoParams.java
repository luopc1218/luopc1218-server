package com.luopc1218.luopc1218server.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetUserInfoParams {
    private Integer id;
    private String name;

    public GetUserInfoParams(Integer id) {
        this.id = id;
    }
}
