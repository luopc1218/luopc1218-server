package com.luopc1218.luopc1218server.entity.article;

import lombok.Data;

import java.util.List;

@Data
public class AddArticleTagLinkBody {
    private Integer id;
    private Integer articleId;
    private List<Integer> TagIdList;

    public AddArticleTagLinkBody(Integer articleId, List<Integer> tagIdList) {
        this.articleId = articleId;
        TagIdList = tagIdList;
    }
}
