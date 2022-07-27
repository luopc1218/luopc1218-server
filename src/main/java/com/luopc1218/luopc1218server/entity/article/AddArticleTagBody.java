package com.luopc1218.luopc1218server.entity.article;

import lombok.Data;

@Data
public class AddArticleTagBody {
    private Integer id;
    private String name;

    public AddArticleTagBody(String name) {
        this.name = name;
    }
}
