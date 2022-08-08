package com.luopc1218.luopc1218server.entity.article;

import lombok.Data;

@Data
public class DeleteArticleBody {
    private Integer articleId;
    private Integer userId;
}
