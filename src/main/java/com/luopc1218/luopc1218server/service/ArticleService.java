package com.luopc1218.luopc1218server.service;

import com.luopc1218.luopc1218server.entity.article.*;
import com.luopc1218.luopc1218server.entity.request.PaginationData;
import com.luopc1218.luopc1218server.repository.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    public List<ArticleTag> getArticleTagList(GetArticleTagListParams getArticleTagListParams) throws RuntimeException {
        return articleMapper.getArticleTagList(getArticleTagListParams);
    }

    public GetArticleInfoResponse addArticle(AddArticleBody addArticleBody) throws RuntimeException {
        articleMapper.addArticle(addArticleBody);
        Integer articleId = addArticleBody.getId();
        List<Integer> tagIdList = addArticleBody.getTags();
        List<String> newTagNameList = addArticleBody.getNewTags();
//        绑定标签
        this.addArticleTagLink(articleId, tagIdList, newTagNameList);
        return this.getArticleInfo(new GetArticleInfoParams(articleId));
    }


    public void addArticleTagLink(Integer articleId, List<Integer> tagIdList, List<String> newTagNameList) throws RuntimeException {
        //        添加标签
        if (newTagNameList.size() > 0) {
            List<Integer> newTagIdList = this.addArticleTags(newTagNameList);
            tagIdList.addAll(newTagIdList);
        }
        List<AddArticleTagLinkBody> addArticleTagLinkBodyList = new ArrayList<>();
        tagIdList.forEach(tagId -> addArticleTagLinkBodyList.add(new AddArticleTagLinkBody(articleId, tagId)));
//        移除原有tag
        articleMapper.deleteArticleTagLink(articleId);
        if (addArticleTagLinkBodyList.size() > 0) {
            articleMapper.addArticleTagLink(addArticleTagLinkBodyList);
        }
    }

    public List<Integer> addArticleTags(List<String> tagNameList) throws RuntimeException {
        List<AddArticleTagBody> addArticleTagBodyList = new ArrayList<>();
        tagNameList.forEach(tagName -> addArticleTagBodyList.add(new AddArticleTagBody(tagName)));
        articleMapper.addArticleTags(addArticleTagBodyList);
        List<Integer> newArticleTagIdList = new ArrayList<>();
        addArticleTagBodyList.forEach(addArticleTagBody -> newArticleTagIdList.add(addArticleTagBody.getId()));
        return newArticleTagIdList;
    }

    public PaginationData<GetArticleListResponse> getArticleList(GetArticleListParams getArticleListParams) throws RuntimeException {
        List<GetArticleListResponse> articleList = articleMapper.getArticleList(getArticleListParams);
        Integer articleListTotalCount = articleMapper.getArticleListTotalCount();
        return new PaginationData<>(articleList, articleListTotalCount);
    }

    public GetArticleInfoResponse getArticleInfo(GetArticleInfoParams getArticleInfoParams) throws RuntimeException {
        return articleMapper.getArticleInfo(getArticleInfoParams);
    }

    public GetArticleEvaluateResponse getArticleEvaluate(Integer articleId, Integer userId) throws RuntimeException {
        GetArticleEvaluateResponse getArticleEvaluateResponse = new GetArticleEvaluateResponse();
        getArticleEvaluateResponse.setFavoriteCount(articleMapper.getArticleFavoriteCount(articleId));
        getArticleEvaluateResponse.setGoodCount(articleMapper.getArticleEvaluateCount(articleId, 1));
        getArticleEvaluateResponse.setBadCount(articleMapper.getArticleEvaluateCount(articleId, 0));
        if (userId != null) {
            ArticleEvaluate articleEvaluate = articleMapper.getArticleEvaluate(articleId, userId);
            getArticleEvaluateResponse.setPickedFavorite(articleMapper.getArticleFavorite(articleId, userId) != null);
            getArticleEvaluateResponse.setPickedGood(articleEvaluate != null && articleEvaluate.getEvaluate() == 1);
            getArticleEvaluateResponse.setPickedBad(articleEvaluate != null && articleEvaluate.getEvaluate() != 1);
        }
        return getArticleEvaluateResponse;
    }

    public GetArticleInfoResponse saveArticle(SaveArticleBody saveArticleBody) throws RuntimeException {
        articleMapper.saveArticle(saveArticleBody);
        Integer articleId = saveArticleBody.getId();
        List<Integer> tagIdList = saveArticleBody.getTags();
        List<String> newTagNameList = saveArticleBody.getNewTags();
//        绑定标签
        this.addArticleTagLink(articleId, tagIdList, newTagNameList);
        return this.getArticleInfo(new GetArticleInfoParams(articleId));
    }

    public void deleteArticle(DeleteArticleBody deleteArticleBody) throws RuntimeException {
        articleMapper.deleteArticleTagLink(deleteArticleBody.getArticleId());
        articleMapper.deleteArticle(deleteArticleBody);
    }

    public void toggleArticleEvaluate(ToggleArticleEvaluateBody toggleArticleEvaluateBody) throws RuntimeException {
        Integer articleId = toggleArticleEvaluateBody.getArticleId();
        Integer userId = toggleArticleEvaluateBody.getUserId();
        String evaluateType = toggleArticleEvaluateBody.getEvaluateType();
        switch (evaluateType) {
            case "favorite" -> {
                if (articleMapper.getArticleFavorite(articleId, userId) != null) {
                    articleMapper.deleteArticleFavorite(articleId, userId);
                } else {
                    articleMapper.addArticleFavorite(articleId, userId);
                }
            }
            case "good" -> {
                ArticleEvaluate articleEvaluate = articleMapper.getArticleEvaluate(articleId, userId);
                if (articleEvaluate != null) {
                    Integer articleEvaluateId = articleEvaluate.getId();
                    if (articleEvaluate.getEvaluate() == 1) {
                        articleMapper.deleteArticleEvaluate(articleEvaluateId);
                    } else {
                        articleMapper.changeArticleEvaluate(articleEvaluateId, 1);
                    }
                } else {
                    articleMapper.addArticleEvaluate(articleId, userId, 1);
                }
            }
            case "bad" -> {
                ArticleEvaluate articleEvaluate = articleMapper.getArticleEvaluate(articleId, userId);
                if (articleEvaluate != null) {
                    Integer articleEvaluateId = articleEvaluate.getId();
                    if (articleEvaluate.getEvaluate() == 0) {
                        articleMapper.deleteArticleEvaluate(articleEvaluateId);
                    } else {
                        articleMapper.changeArticleEvaluate(articleEvaluateId, 0);
                    }
                } else {
                    articleMapper.addArticleEvaluate(articleId, userId, 0);
                }
            }
        }

    }

    public void addArticleViewCount(AddArticleViewCountBody addArticleViewCountBody) throws RuntimeException {
        articleMapper.addArticleViewCount(addArticleViewCountBody);
    }

    public void addArticleComment(AddArticleCommentBody addArticleCommentBody) throws RuntimeException {
        articleMapper.addArticleComment(addArticleCommentBody);
    }

    public PaginationData<ArticleComment> getArticleCommentList(GetArticleCommentListParams getArticleCommentListParams) throws RuntimeException {
        List<ArticleComment> articleCommentList = articleMapper.getArticleCommentList(getArticleCommentListParams);
        Integer articleCommentCount = articleMapper.getArticleCommentCount(getArticleCommentListParams);
        return new PaginationData<>(articleCommentList, articleCommentCount);
    }

    public PaginationData<ArticleComment> getArticleSubCommentList(GetArticleSubCommentListParams getArticleSubCommentListParams) {
        List<ArticleComment> articleSubCommentList = articleMapper.getArticleSubCommentList(getArticleSubCommentListParams);
        Integer articleSubCommentCount = articleMapper.getArticleSubCommentCount(getArticleSubCommentListParams.getCommentId());
        return new PaginationData<>(articleSubCommentList, articleSubCommentCount);
    }

    public List<GetArticleListResponse> getHotArticleList() {
        return articleMapper.getHotArticleList();
    }
}
