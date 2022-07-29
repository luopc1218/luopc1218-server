package com.luopc1218.luopc1218server.entity.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetArticleInfoResponse {
    private Integer id;
    private String title;
    private String description;
    private String content;
    private Integer authorId;
    private String authorName;
    private String authorAvatarUrl;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;
    private java.sql.Timestamp deleteTime;
    private List<ArticleTag> tags;
}
