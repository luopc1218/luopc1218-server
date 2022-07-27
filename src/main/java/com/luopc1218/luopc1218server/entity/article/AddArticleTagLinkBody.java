package com.luopc1218.luopc1218server.entity.article;

import lombok.Data;

@Data
public class AddArticleTagLinkBody {
    private Integer id;
    private Integer articleId;
    private Integer tagId;

    public AddArticleTagLinkBody(Integer articleId, Integer tagId) {
        this.articleId = articleId;
        this.tagId = tagId;
    }
}
