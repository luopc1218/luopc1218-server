package com.luopc1218.luopc1218server.service;

import com.luopc1218.luopc1218server.entity.article.*;
import com.luopc1218.luopc1218server.repository.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    public List<ArticleTag> getArticleTagList(String query) throws RuntimeException {
        return articleMapper.getArticleTagList(query);
    }

    public GetArticleInfoResponse addArticle(AddArticleBody addArticleBody) throws RuntimeException {
        articleMapper.addArticle(addArticleBody);
        Integer articleId = addArticleBody.getId();
        List<Integer> tagIdList = addArticleBody.getTags();
        List<String> newTagNameList = addArticleBody.getNewTags();
//        添加标签
        if (newTagNameList.size() > 0) {
            List<Integer> newTagIdList = this.addArticleTags(addArticleBody.getNewTags());
            tagIdList.addAll(newTagIdList);
        }
//        绑定标签
        this.addArticleTagLink(articleId, tagIdList);
        return this.getArticleInfo(new GetArticleInfoParams(articleId));
    }


    public void addArticleTagLink(Integer articleId, List<Integer> tagIdList) throws RuntimeException {
        List<AddArticleTagLinkBody> addArticleTagLinkBodyList = new ArrayList<>();
        tagIdList.forEach(tagId -> addArticleTagLinkBodyList.add(new AddArticleTagLinkBody(articleId, tagId)));
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

    public List<GetArticleListResponse> getArticleList(GetArticleListParams getArticleListParams) throws RuntimeException {
        return articleMapper.getArticleList(getArticleListParams);
    }

    public GetArticleInfoResponse getArticleInfo(GetArticleInfoParams getArticleInfoParams) throws RuntimeException {
        return articleMapper.getArticleInfo(getArticleInfoParams);
    }
}
