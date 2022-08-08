package com.luopc1218.luopc1218server.entity.article;

import lombok.Data;

import java.util.List;

@Data
public class AddArticleBody {
    private Integer id;
    private Integer userId;
    private String title;
    private String description;
    private List<Integer> tags;
    private List<String> newTags;
    private String content;

}
