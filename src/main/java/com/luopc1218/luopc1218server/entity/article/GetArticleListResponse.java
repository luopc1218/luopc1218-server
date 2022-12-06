package com.luopc1218.luopc1218server.entity.article;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetArticleListResponse {
    private Integer id;
    private String title;
    private String description;
    private Integer authorId;
    private Integer viewCount;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp deleteTime;
    private String authorName;
    private String authorAvatarUrl;
    private List<ArticleTag> tags;
}
