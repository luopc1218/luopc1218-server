package com.luopc1218.luopc1218server.controller;

import com.luopc1218.luopc1218server.entity.request.ApiResponse;
import com.luopc1218.luopc1218server.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController {

    @Autowired
    SystemService systemService;

    @RequestMapping(value = "/getNavLink", method = RequestMethod.GET)
    public ApiResponse getNavLink() {
        try {
            return ApiResponse.success(systemService.getSiteLinkList());
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "/getCountryTelCodeList", method = RequestMethod.GET)
    public ApiResponse getPhoneCodeList() {
        try {
            return ApiResponse.success(systemService.getCountryTelCodeList());
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }
}
