package com.luopc1218.luopc1218server.entity.article;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class ArticleTag {

    private Integer id;
    private String name;
    private java.sql.Timestamp createTime;

    public ArticleTag(Integer id, String name, Timestamp createTime) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
    }
}
