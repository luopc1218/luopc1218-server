package com.luopc1218.luopc1218server.entity.indexData;

import lombok.Data;

import java.util.List;

@Data
public class GetIndexDataResponse {
    private String title;
    private List<Path> paths;
    private List<About> abouts;

    public GetIndexDataResponse(IndexData indexData, List<Path> paths, List<About> abouts) {
        this.title = indexData.getTitle();
        this.paths = paths;
        this.abouts = abouts;
    }
}
