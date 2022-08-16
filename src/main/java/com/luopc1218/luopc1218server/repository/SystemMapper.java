package com.luopc1218.luopc1218server.repository;

import com.luopc1218.luopc1218server.entity.CountryTelCode;
import com.luopc1218.luopc1218server.entity.GetNoticeResponse;
import com.luopc1218.luopc1218server.entity.Notice;
import com.luopc1218.luopc1218server.entity.SiteLink;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SystemMapper {
    List<CountryTelCode> getCountryTelCodeList();

    GetNoticeResponse getNotice();
}
