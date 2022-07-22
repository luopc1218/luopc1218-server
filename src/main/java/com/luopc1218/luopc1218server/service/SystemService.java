package com.luopc1218.luopc1218server.service;

import com.luopc1218.luopc1218server.entity.CountryTelCode;
import com.luopc1218.luopc1218server.entity.SiteLink;
import com.luopc1218.luopc1218server.repository.SystemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemService {

    @Autowired
    SystemMapper systemMapper;

    public List<SiteLink> getSiteLinkList() {
        return systemMapper.getSiteLinkList();
    }

    public List<CountryTelCode> getCountryTelCodeList() {
        return systemMapper.getCountryTelCodeList();
    }
}
