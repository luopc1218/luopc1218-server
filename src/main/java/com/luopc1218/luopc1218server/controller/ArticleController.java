package com.luopc1218.luopc1218server.controller;

import com.luopc1218.luopc1218server.entity.article.AddArticleBody;
import com.luopc1218.luopc1218server.entity.article.Article;
import com.luopc1218.luopc1218server.entity.request.ApiResponse;
import com.luopc1218.luopc1218server.service.ArticleService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/getArticleTagList", method = RequestMethod.GET)
    public ApiResponse getArticleTagList(@RequestParam("query") String query) {
        try {
            return ApiResponse.success(articleService.getArticleTagList(query));
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "addArticle", method = RequestMethod.POST)
    public ApiResponse addArticle(HttpServletRequest request, @RequestBody AddArticleBody addArticleBody) {
        try {
            Integer userId = (Integer) request.getAttribute("CURRENT_USER_ID");
            addArticleBody.setUserId(userId);
            Article article = articleService.addArticle(addArticleBody);
            return ApiResponse.success(article);
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }
}
