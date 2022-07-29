package com.luopc1218.luopc1218server.entity.article;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleTag {
    private Integer id;
    private String name;
    private java.sql.Timestamp createTime;

}
