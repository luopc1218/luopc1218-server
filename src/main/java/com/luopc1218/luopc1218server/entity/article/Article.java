package com.luopc1218.luopc1218server.entity.article;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class Article {

    private Integer id;
    private String title;
    private String description;
    private String content;
    private Integer authorId;
    private Integer viewCount;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp deleteTime;
}
