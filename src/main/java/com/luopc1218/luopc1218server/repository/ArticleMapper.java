package com.luopc1218.luopc1218server.repository;

import com.luopc1218.luopc1218server.entity.article.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {

    List<ArticleTag> getArticleTagList(String query);

    void addArticle(@Param("addArticleBody") AddArticleBody addArticleBody);

    Article getArticleInfoById(@Param("articleId") Integer articleId);

    void addArticleTags(List<AddArticleTagBody> newTagList);

    void addArticleTagLink(List<AddArticleTagLinkBody> addArticleTagLinkBodyList);

    List<GetArticleListResponse> getArticleList(@Param("getArticleListParams") GetArticleListParams getArticleListParams);
}
