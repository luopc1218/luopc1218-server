package com.luopc1218.luopc1218server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SiteLink {
    private Integer id;
    private String label;
    private String url;
}
