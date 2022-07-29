package com.luopc1218.luopc1218server.entity.article;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class GetArticleTagListParams {
    private String query;
    private Integer articleId;
}
