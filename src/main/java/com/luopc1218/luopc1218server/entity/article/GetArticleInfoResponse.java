package com.luopc1218.luopc1218server.entity.article;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetArticleInfoResponse extends Article {
    private String authorName;
    private String authorAvatarUrl;
    private List<ArticleTag> tags;
}
