package com.luopc1218.luopc1218server.entity.indexData;

import lombok.Data;

@Data
public class About {
    private String key;
    private String value;

    public About(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
