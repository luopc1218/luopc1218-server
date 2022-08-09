package com.luopc1218.luopc1218server.entity.article;


public class ArticleEvaluate {

  private Integer id;
  private Integer articleId;
  private Integer evaluate;
  private Integer userId;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getArticleId() {
    return articleId;
  }

  public void setArticleId(Integer articleId) {
    this.articleId = articleId;
  }


  public Integer getEvaluate() {
    return evaluate;
  }

  public void setEvaluate(Integer evaluate) {
    this.evaluate = evaluate;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

}
