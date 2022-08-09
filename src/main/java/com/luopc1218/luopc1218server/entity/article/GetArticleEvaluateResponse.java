package com.luopc1218.luopc1218server.entity.article;

import lombok.Data;

@Data
public class GetArticleEvaluateResponse {
    private Integer favoriteCount;
    private Integer goodCount;
    private Integer badCount;
    private Boolean pickedFavorite;
    private Boolean pickedGood;
    private Boolean pickedBad;
}
