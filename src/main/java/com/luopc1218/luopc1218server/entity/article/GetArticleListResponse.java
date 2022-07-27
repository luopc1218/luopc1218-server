package com.luopc1218.luopc1218server.entity.article;

import lombok.Data;

import java.util.List;

@Data
public class GetArticleListResponse {
    private long id;
    private String title;
    private String description;
    private List<ArticleTag> tags;
    private String content;
    private Integer authorId;
    private String authorName;
    private String authorAvatarUrl;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;
    private java.sql.Timestamp deleteTime;
}
