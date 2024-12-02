package com.hanfeng.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hanfeng.constants.enums.HttpCodeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> implements Serializable {

    private Integer code = HttpCodeEnum.SUCCESS.getCode();;
    private String msg = HttpCodeEnum.SUCCESS.getMsg();
    private T data = null;

    public static <T> ResponseResult<T> result(int code, String msg, T data) {
        ResponseResult<T> result = new ResponseResult<T>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> ResponseResult<T> success() {
        return result(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getMsg(), null);
    }

    public static <T> ResponseResult<T> success(T data) {
        return result(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getMsg(), data);
    }

    public static <T> ResponseResult<T> success(String msg, T data) {
        return result(HttpCodeEnum.SUCCESS.getCode(), msg, data);
    }

    public static <T> ResponseResult<T> fail() {
        return result(HttpCodeEnum.COMMON_FAIL.getCode(), HttpCodeEnum.COMMON_FAIL.getMsg(), null);
    }

    public static <T> ResponseResult<T> fail(String msg) {
        return result(HttpCodeEnum.COMMON_FAIL.getCode(), msg, null);
    }

    public static <T> ResponseResult<T> fail(HttpCodeEnum enums, String msg) {
        return result(enums.getCode(), msg, null);
    }

    private static <T> ResponseResult<T> fail(HttpCodeEnum enums, String msg, T data) {
        return result(enums.getCode(), msg, data);
    }

}