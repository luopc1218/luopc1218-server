package com.luopc1218.luopc1218server.controller;

import com.luopc1218.luopc1218server.entity.request.ApiResponse;
import com.luopc1218.luopc1218server.entity.request.ApiResponseStatus;
import com.luopc1218.luopc1218server.entity.user.GetUserInfoParams;
import com.luopc1218.luopc1218server.entity.user.SignInBody;
import com.luopc1218.luopc1218server.entity.user.SignUpBody;
import com.luopc1218.luopc1218server.service.UserService;
import com.luopc1218.luopc1218server.util.annotation.JsonWebTokenRequire;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @JsonWebTokenRequire
    @RequestMapping(value = "/checkSignIn", method = RequestMethod.GET)
    public ApiResponse checkSignIn() {
        return ApiResponse.success();
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public ApiResponse getUserInfo(HttpServletRequest request, @RequestParam(value = "id", required = false) Integer id, @RequestParam(value = "name", required = false) String name) {
        try {
            GetUserInfoParams getUserInfoParams = new GetUserInfoParams();
            if (id == null && name == null) {
                Integer userId = (Integer) request.getAttribute("CURRENT_USER_ID");
                if (userId == null) {
                    return ApiResponse.fail(ApiResponseStatus.NEED_SIGN_IN);
                } else {
                    getUserInfoParams.setId(userId);
                    return ApiResponse.success(userService.getUserInfo(getUserInfoParams));
                }
            }
            getUserInfoParams.setId(id);
            getUserInfoParams.setName(name);
            return ApiResponse.success(userService.getUserInfo(getUserInfoParams));
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "/getAdminInfo", method = RequestMethod.GET)
    public ApiResponse getAdminInfo() {
        try {
            GetUserInfoParams getUserInfoParams = new GetUserInfoParams();
            getUserInfoParams.setName("luopc1218");
            return ApiResponse.success(userService.getUserInfo(getUserInfoParams));
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public ApiResponse signIn(@RequestBody SignInBody signInBody) {
        try {
            String token = userService.signIn(signInBody);
            return ApiResponse.success(token, "登录成功");
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ApiResponse signUp(@RequestBody SignUpBody signUpBody) {
        try {
            return ApiResponse.success(userService.signUp(signUpBody), "注册成功");
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    @JsonWebTokenRequire
    @RequestMapping(value = "/changeAvatar", method = RequestMethod.POST)
    public ApiResponse changeAvatar(HttpServletRequest request, @RequestBody Map<String, Object> params) {
        try {
            Integer userId = (Integer) request.getAttribute("CURRENT_USER_ID");
            String url = (String) params.get("url");
            userService.changeAvatar(userId, url);
            return ApiResponse.success("修改成功");
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    @JsonWebTokenRequire
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public ApiResponse changePassword(HttpServletRequest request, @RequestBody Map<String, Object> changePasswordForm) {
        try {
            Integer userId = (Integer) request.getAttribute("CURRENT_USER_ID");
            userService.changePassword(userId, changePasswordForm);
            return ApiResponse.success("修改成功");
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "/checkSignUpUsername", method = RequestMethod.GET)
    public ApiResponse checkSignUpUsername(@RequestParam("username") String username) {
        try {
            userService.checkSignUpUsername(username);
            return ApiResponse.success();
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }
}

