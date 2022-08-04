package com.luopc1218.luopc1218server.entity.request;

import lombok.Data;

@Data
public class Pagination {
    private Integer page;
    private Integer pageSize;

    private Integer limit;

    public Pagination() {
    }

    public Pagination(Integer page, Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;
        this.limit = (page - 1) * pageSize;
    }


}
