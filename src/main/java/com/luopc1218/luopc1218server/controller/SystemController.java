package com.luopc1218.luopc1218server.controller;

import com.luopc1218.luopc1218server.entity.request.ApiResponse;
import com.luopc1218.luopc1218server.entity.request.ApiResponseStatus;
import com.luopc1218.luopc1218server.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController {

    @Autowired
    SystemService systemService;

    @RequestMapping(value = "/getCountryTelCodeList", method = RequestMethod.GET)
    public ApiResponse getPhoneCodeList() {
        try {
            return ApiResponse.success(systemService.getCountryTelCodeList());
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "/sendPhoneCheckCode", method = RequestMethod.POST)
    public ApiResponse sendPhoneCheckCode() {
        return ApiResponse.fail(ApiResponseStatus.DEVELOPING);
    }

    @RequestMapping(value = "/getNotice", method = RequestMethod.GET)
    public ApiResponse getNotice() {

        try {
            return ApiResponse.success(systemService.getNotice());
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }
}
