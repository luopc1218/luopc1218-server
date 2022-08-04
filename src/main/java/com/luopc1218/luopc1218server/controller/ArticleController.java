package com.luopc1218.luopc1218server.controller;

import com.luopc1218.luopc1218server.entity.article.*;
import com.luopc1218.luopc1218server.entity.request.ApiResponse;
import com.luopc1218.luopc1218server.service.ArticleService;
import com.luopc1218.luopc1218server.util.annotation.JsonWebTokenRequire;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/getArticleList", method = RequestMethod.GET)
    public ApiResponse getArticleList(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize) {
        try {
            GetArticleListParams getArticleListParams = new GetArticleListParams(page,pageSize);
            return ApiResponse.success(articleService.getArticleList(getArticleListParams));
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "/getArticleTagList", method = RequestMethod.GET)
    public ApiResponse getArticleTagList(@RequestParam("query") String query) {
        try {
            GetArticleTagListParams getArticleTagListParams = new GetArticleTagListParams();
            if (query != null) {
                getArticleTagListParams.setQuery(query);
            }
            return ApiResponse.success(articleService.getArticleTagList(getArticleTagListParams));
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    @JsonWebTokenRequire
    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public ApiResponse addArticle(HttpServletRequest request, @RequestBody AddArticleBody addArticleBody) {
        try {
            Integer userId = (Integer) request.getAttribute("CURRENT_USER_ID");
            addArticleBody.setUserId(userId);
            return ApiResponse.success(articleService.addArticle(addArticleBody));
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "/getArticleInfo", method = RequestMethod.GET)
    public ApiResponse getArticleInfo(@RequestParam("id") Integer id) {
        try {
            GetArticleInfoParams getArticleInfoParams = new GetArticleInfoParams();
            if (id != null) {
                getArticleInfoParams.setId(id);
            }
            GetArticleInfoResponse getArticleListResponse = articleService.getArticleInfo(getArticleInfoParams);
            return ApiResponse.success(getArticleListResponse);
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }
}
