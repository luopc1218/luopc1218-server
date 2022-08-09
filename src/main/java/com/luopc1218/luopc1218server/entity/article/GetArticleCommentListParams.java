package com.luopc1218.luopc1218server.entity.article;

import com.luopc1218.luopc1218server.entity.request.Pagination;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetArticleCommentListParams extends Pagination {
    private Integer articleId;

    public GetArticleCommentListParams() {

    }

    public GetArticleCommentListParams(Integer page, Integer pageSize) {
        super(page, pageSize);
    }
}
