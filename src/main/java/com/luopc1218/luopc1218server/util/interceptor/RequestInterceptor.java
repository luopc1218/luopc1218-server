package com.luopc1218.luopc1218server.util.interceptor;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luopc1218.luopc1218server.entity.request.ApiResponse;
import com.luopc1218.luopc1218server.entity.request.ApiResponseStatus;
import com.luopc1218.luopc1218server.util.annotation.JsonWebTokenRequire;
import com.luopc1218.luopc1218server.util.jwt.Jwt;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

@Slf4j
public class RequestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) {
        ApiResponse fail;
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        } else {
            // 反射获取方法上的LoginRequred注解
            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            jwt合法时注入userId
            String jwtToken = request.getHeader("Authorization");
            if (jwtToken != null && Jwt.checkJwtToken(jwtToken)) {
                DecodedJWT decodedJWT = Jwt.getJwtToken(jwtToken);
                Integer userId = decodedJWT.getClaim("userId").asInt();
                request.setAttribute("CURRENT_USER_ID", userId);
            }
            //        需要token校验
            JsonWebTokenRequire jsonWebTokenRequire = handlerMethod.getMethod().getAnnotation(JsonWebTokenRequire.class);
            if (jsonWebTokenRequire != null) {
                if (jwtToken == null || jwtToken.equals("")) {
//            没有token
                    fail = ApiResponse.fail(ApiResponseStatus.NEED_SIGN_IN);
                } else if (!Jwt.checkJwtToken(jwtToken)) {
                    fail = ApiResponse.fail(ApiResponseStatus.SIGN_IN_EXPIRED);
                } else {
//            token失效
                    return true;
                }
                try {
                    //  获取输出流
                    ServletOutputStream outputStream = response.getOutputStream();
                    //  序列化工具
                    ObjectMapper objectMapper = new ObjectMapper();
                    //  将 ApiResponse 序列化为 字节
                    byte[] bytes = objectMapper.writeValueAsBytes(fail);
                    //  写入输出流
                    outputStream.write(bytes);
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.setContentType("application/json;charset=UTF-8");
                    //  刷新
                    response.flushBuffer();
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            } else {
                return true;
            }
        }
    }
}
