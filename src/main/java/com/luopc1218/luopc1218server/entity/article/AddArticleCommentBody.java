package com.luopc1218.luopc1218server.entity.article;

import lombok.Data;

@Data
public class AddArticleCommentBody {
    private Integer authorId;
    private Integer articleId;
    private String content;
}
