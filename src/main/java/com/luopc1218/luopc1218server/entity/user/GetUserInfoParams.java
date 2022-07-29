package com.luopc1218.luopc1218server.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserInfoParams {
    private Integer id;
    private String name;
}
