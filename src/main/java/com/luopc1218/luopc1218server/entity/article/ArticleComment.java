package com.luopc1218.luopc1218server.entity.article;

import lombok.Data;

@Data
public class ArticleComment {

    private Integer id;
    private Integer articleId;
    private Integer authorId;
    private String content;
    private Integer targetId;
    private java.sql.Timestamp createTime;

}
