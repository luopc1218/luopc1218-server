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
}
