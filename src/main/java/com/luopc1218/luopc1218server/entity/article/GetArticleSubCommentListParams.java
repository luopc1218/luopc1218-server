package com.luopc1218.luopc1218server.entity.article;

import com.luopc1218.luopc1218server.entity.request.Pagination;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetArticleSubCommentListParams extends Pagination {
    private Integer commentId;

    public GetArticleSubCommentListParams(Integer page, Integer pageSize, Integer commentId) {
        super(page, pageSize);
        this.commentId = commentId;
    }
}
