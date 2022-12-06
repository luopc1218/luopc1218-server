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

    Integer getArticleListCount(Integer authorId);

    GetArticleInfoResponse getArticleInfo(@Param("getArticleInfoParams") GetArticleInfoParams getArticleInfoParams);

    void saveArticle(@Param("saveArticleBody") SaveArticleBody saveArticleBody);

    void deleteArticleTagLink(Integer articleId);

    void deleteArticle(@Param("deleteArticleBody") DeleteArticleBody deleteArticleBody);

    Integer getArticleFavoriteCount(Integer articleId);

    Integer getArticleEvaluateCount(Integer articleId, Integer evaluate);

    ArticleFavorite getArticleFavorite(Integer articleId, Integer userId);

    ArticleEvaluate getArticleEvaluate(Integer articleId, Integer userId);

    void deleteArticleFavorite(Integer articleId, Integer userId);

    void addArticleFavorite(Integer articleId, Integer userId);

    void addArticleViewCount(@Param("addArticleViewCountBody") AddArticleViewCountBody addArticleViewCountBody);

    void deleteArticleEvaluate(Integer articleEvaluateId);

    void changeArticleEvaluate(Integer id, Integer evaluate);

    void addArticleEvaluate(Integer articleId, Integer userId, Integer evaluate);


    void addArticleComment(@Param("addArticleCommentBody") AddArticleCommentBody addArticleCommentBody);

    List<ArticleComment> getArticleCommentList(@Param("getArticleCommentListParams") GetArticleCommentListParams getArticleCommentListParams);

    Integer getArticleCommentCount(@Param("getArticleCommentListParams") GetArticleCommentListParams getArticleCommentListParams);

    List<ArticleComment> getArticleSubCommentList(@Param("getArticleSubCommentListParams") GetArticleSubCommentListParams getArticleSubCommentListParams);

    Integer getArticleSubCommentCount(Integer commentId);

    List<GetArticleListResponse> getHotArticleList();

    List<GetArticleListResponse> getArticleFavoriteList(@Param("getArticleFavoriteListParams") GetArticleFavoriteListParams getArticleFavoriteListParams);

    Integer getArticleFavoriteListCount(@Param("getArticleFavoriteListParams") GetArticleFavoriteListParams getArticleFavoriteListParams);
}
