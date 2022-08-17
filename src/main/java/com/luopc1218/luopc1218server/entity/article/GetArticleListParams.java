package com.luopc1218.luopc1218server.entity.article;

import com.luopc1218.luopc1218server.entity.request.Pagination;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetArticleListParams extends Pagination {
    private Integer authorId;


    public GetArticleListParams() {
    }

    public GetArticleListParams(Integer page, Integer pageSize) {
        super(page, pageSize);
    }
}
