package com.luopc1218.luopc1218server.entity.indexData;

import lombok.Data;


@Data
public class Path {
    private String title;
    private String description;
    private String time;

    public Path(String title, String description, String time) {
        this.title = title;
        this.description = description;
        this.time = time;
    }
}
