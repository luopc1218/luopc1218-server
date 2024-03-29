package com.luopc1218.luopc1218server.entity.request;

public enum ApiResponseStatus {
    SUCCESS(200, "", true),
    FAIL(-1, "", false),
    DEVELOPING(-1, "接口开发中", false),
    NEED_SIGN_IN(401, "请先登录", false),
    SIGN_IN_EXPIRED(401, "登录信息失效，请重新登录", false);

    private final Integer code;
    private final String message;
    private final Boolean success;

    ApiResponseStatus(Integer code, String message, Boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getSuccess() {
        return success;
    }

}
