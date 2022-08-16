package com.luopc1218.luopc1218server.entity.article;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetArticleSubCommentListResponse extends ArticleComment {
    private String authorName;
    private String authorAvatarUrl;
    private GetArticleSubCommentListResponse replyComment;
}
