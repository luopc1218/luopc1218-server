package com.luopc1218.luopc1218server.repository;

import com.luopc1218.luopc1218server.entity.ChangeNoticeBody;
import com.luopc1218.luopc1218server.entity.CountryTelCode;
import com.luopc1218.luopc1218server.entity.GetNoticeResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SystemMapper {
    List<CountryTelCode> getCountryTelCodeList();

    GetNoticeResponse getNotice();

    void changeNotice(@Param("changeNoticeBody") ChangeNoticeBody changeNoticeBody);
}
