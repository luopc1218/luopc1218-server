package com.luopc1218.luopc1218server.entity.article;

import java.sql.Timestamp;
import java.util.List;

public class GetArticleListResponse extends GetArticleInfoResponse {

    public GetArticleListResponse(Integer id, String title, String description, String content, Integer authorId, String authorName, String authorAvatarUrl, Timestamp createTime, Timestamp updateTime, Timestamp deleteTime, List<ArticleTag> tags) {
        super(id, title, description, content, authorId, authorName, authorAvatarUrl, createTime, updateTime, deleteTime, tags);
    }
}
