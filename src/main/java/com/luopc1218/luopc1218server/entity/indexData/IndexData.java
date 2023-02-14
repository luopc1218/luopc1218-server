package com.luopc1218.luopc1218server.entity.indexData;

import lombok.Data;

@Data
public class IndexData {
    private Integer id;
    private String title;


    public IndexData(Integer id, String title) {
        this.id = id;
        this.title = title;
    }
}
