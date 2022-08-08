package com.luopc1218.luopc1218server.repository;

import com.luopc1218.luopc1218server.entity.article.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {

    List<ArticleTag> getArticleTagList(@Param("getArticleTagListParams") GetArticleTagListParams getArticleTagListParams);

    void addArticle(@Param("addArticleBody") AddArticleBody addArticleBody);


    void addArticleTags(List<AddArticleTagBody> newTagList);

    void addArticleTagLink(List<AddArticleTagLinkBody> addArticleTagLinkBodyList);

    List<GetArticleListResponse> getArticleList(@Param("getArticleListParams") GetArticleListParams getArticleListParams);

    Integer getArticleListTotalCount();

    GetArticleInfoResponse getArticleInfo(@Param("getArticleInfoParams") GetArticleInfoParams getArticleInfoParams);

    void saveArticle(@Param("saveArticleBody") SaveArticleBody saveArticleBody);

    void deleteArticleTagLink(Integer articleId);

    void deleteArticle(@Param("deleteArticleBody") DeleteArticleBody deleteArticleBody);
}
