package com.yuanqi.comm;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by fengqiang on 2019/7/17.
 */

public class ResponseUtil {

    public ResponseUtil() {
    }

    public static <T> Response<T> buildResponse(T data) {
        return new Response(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> Response<T> buildErrorResponse(int code, String msg) {
        return new Response(code, msg);
    }

    public static <T> Response<T> buildErrorResponse(ResponseCode responseCode, String msg) {
        return new Response(responseCode.getCode(), msg);
    }

    public static <T> Response<T> buildErrorResponse(ResponseCode responseCode) {
        return new Response(responseCode.getCode(), responseCode.getDescription());
    }

    public static <T> Response<T> buildErrorResponse(Throwable sgException) {
        return null != sgException && !StringUtils.isBlank(sgException.getLocalizedMessage()) ? new Response(ResponseCode.SYSTEM_ERROR.getCode(), sgException.getLocalizedMessage()) : buildErrorResponse();
    }

    public static <T> Response<T> buildErrorResponse() {
        return new Response(ResponseCode.SYSTEM_ERROR.getCode(), ResponseCode.SYSTEM_ERROR.getDescription());
    }

    public static <T> Response<T> buildInVisibleResponse(T data) {
        return new Response(ResponseCode.SUCCESS.getCode(), data, ResponseCode.SUCCESS.getDescription(), false);
    }
}