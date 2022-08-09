package com.luopc1218.luopc1218server.controller;

import com.luopc1218.luopc1218server.entity.article.*;
import com.luopc1218.luopc1218server.entity.request.ApiResponse;
import com.luopc1218.luopc1218server.service.ArticleService;
import com.luopc1218.luopc1218server.util.annotation.JsonWebTokenRequire;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

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

    @RequestMapping(value = "/getArticleList", method = RequestMethod.GET)
    public ApiResponse getArticleList(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize) {
        try {
            GetArticleListParams getArticleListParams = new GetArticleListParams(page, pageSize);
            return ApiResponse.success(articleService.getArticleList(getArticleListParams));
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "/getArticleEvaluate", method = RequestMethod.GET)
    public ApiResponse getArticleEvaluate(HttpServletRequest request, @RequestParam("articleId") Integer articleId) {
        try {
            Integer userId = (Integer) request.getAttribute("CURRENT_USER_ID");
            return ApiResponse.success(articleService.getArticleEvaluate(articleId, userId));
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "/addArticleViewCount", method = RequestMethod.POST)
    public ApiResponse addArticleViewCount(@RequestBody AddArticleViewCountBody addArticleViewCountBody) {
        try {
            articleService.addArticleViewCount(addArticleViewCountBody);
            return ApiResponse.success();
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "/toggleArticleEvaluate", method = RequestMethod.POST)
    public ApiResponse toggleArticleEvaluate(HttpServletRequest request, @RequestBody ToggleArticleEvaluateBody toggleArticleEvaluateBody) {
        try {
            Integer userId = (Integer) request.getAttribute("CURRENT_USER_ID");
            toggleArticleEvaluateBody.setUserId(userId);
            articleService.toggleArticleEvaluate(toggleArticleEvaluateBody);
            return ApiResponse.success();
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

    @JsonWebTokenRequire
    @RequestMapping(value = "/saveArticle", method = RequestMethod.POST)
    public ApiResponse saveArticle(HttpServletRequest request, @RequestBody SaveArticleBody saveArticleBody) {
        try {
            Integer userId = (Integer) request.getAttribute("CURRENT_USER_ID");
            saveArticleBody.setUserId(userId);
            return ApiResponse.success(articleService.saveArticle(saveArticleBody));
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    @JsonWebTokenRequire
    @RequestMapping(value = "/deleteArticle", method = RequestMethod.POST)
    public ApiResponse deleteArticle(HttpServletRequest request, @RequestBody DeleteArticleBody deleteArticleBody) {
        try {
            Integer userId = (Integer) request.getAttribute("CURRENT_USER_ID");
            deleteArticleBody.setUserId(userId);
            articleService.deleteArticle(deleteArticleBody);
            return ApiResponse.success();
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    @JsonWebTokenRequire
    @RequestMapping(value = "/addArticleComment", method = RequestMethod.POST)
    public ApiResponse addArticleComment(HttpServletRequest request, @RequestBody AddArticleCommentBody addArticleCommentBody) {
        try {
            Integer userId = (Integer) request.getAttribute("CURRENT_USER_ID");
            addArticleCommentBody.setAuthorId(userId);
            articleService.addArticleComment(addArticleCommentBody);
            return ApiResponse.success();
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "/getArticleCommentList", method = RequestMethod.GET)
    public ApiResponse getArticleCommentList(@Param("page") Integer page, @Param("pageSize") Integer pageSize, @Param("articleId") Integer articleId) {
        try {
            GetArticleCommentListParams getArticleCommentListParams = new GetArticleCommentListParams(page, pageSize);
            getArticleCommentListParams.setArticleId(articleId);
            return ApiResponse.success(articleService.getArticleCommentList(getArticleCommentListParams));
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }
}
