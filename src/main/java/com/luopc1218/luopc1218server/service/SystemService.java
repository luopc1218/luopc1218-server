package com.luopc1218.luopc1218server.service;

import com.luopc1218.luopc1218server.entity.*;
import com.luopc1218.luopc1218server.entity.request.ApiResponse;
import com.luopc1218.luopc1218server.repository.SystemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemService {

    @Autowired
    SystemMapper systemMapper;


    public List<CountryTelCode> getCountryTelCodeList() {
        return systemMapper.getCountryTelCodeList();
    }

    public GetNoticeResponse getNotice() {
        return systemMapper.getNotice();
    }

    public void changeNotice(ChangeNoticeBody changeNoticeBody) {
        systemMapper.changeNotice(changeNoticeBody);
    }
}
