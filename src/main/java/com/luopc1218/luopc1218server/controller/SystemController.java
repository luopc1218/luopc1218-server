package com.luopc1218.luopc1218server.controller;

import com.luopc1218.luopc1218server.entity.ChangeNoticeBody;
import com.luopc1218.luopc1218server.entity.request.ApiResponse;
import com.luopc1218.luopc1218server.entity.request.ApiResponseStatus;
import com.luopc1218.luopc1218server.service.SystemService;
import com.luopc1218.luopc1218server.util.annotation.JsonWebTokenRequire;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @JsonWebTokenRequire
    @RequestMapping(value = "/changeNotice", method = RequestMethod.POST)
    public ApiResponse changeNotice(HttpServletRequest request, @RequestBody ChangeNoticeBody changeNoticeBody) {
        try {
            Integer userId = (Integer) request.getAttribute("CURRENT_USER_ID");
            changeNoticeBody.setAuthorId(userId);
            systemService.changeNotice(changeNoticeBody);
            return ApiResponse.success();
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "/getIndexData",method = RequestMethod.GET)
    public  ApiResponse getIndexData(){
        try {
            return ApiResponse.success(systemService.getIndexData());
        }catch (Exception e){
            return ApiResponse.fail(e.getMessage());
        }
    }
}
