package com.luopc1218.luopc1218server.entity.article;

import lombok.Data;

@Data
public class ToggleArticleEvaluateBody {
    private Integer articleId;
    private Integer userId;
    private String evaluateType;
}
