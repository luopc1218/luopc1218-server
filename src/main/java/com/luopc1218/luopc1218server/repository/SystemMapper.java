package com.luopc1218.luopc1218server.repository;

import com.luopc1218.luopc1218server.entity.ChangeNoticeBody;
import com.luopc1218.luopc1218server.entity.CountryTelCode;
import com.luopc1218.luopc1218server.entity.GetNoticeResponse;
import com.luopc1218.luopc1218server.entity.indexData.About;
import com.luopc1218.luopc1218server.entity.indexData.IndexData;
import com.luopc1218.luopc1218server.entity.indexData.Path;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SystemMapper {
    List<CountryTelCode> getCountryTelCodeList();

    GetNoticeResponse getNotice();

    void changeNotice(@Param("changeNoticeBody") ChangeNoticeBody changeNoticeBody);

    @Select("select * from index_data where id=1;")
    IndexData getIndexData();

    @Select("select title,description,time from index_data_paths;")
    List<Path> getIndexDataPaths();

    @Select("select `key`,value from index_data_abouts;")
    List<About> getIndexDataAbouts();
}
