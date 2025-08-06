package com.mrkloklo.weblog.common.utils;

import java.io.Serializable;

import com.mrkloklo.weblog.common.exception.BizException;
import lombok.Data;

/**
 * @author: gujhao
 * @date: 2025-08-04 15:38
 * @description 响应参数工具类:
 **/
@Data
public class Response<T> implements Serializable {


    private Object status;

    private Object custom;

    // =================================== 成功响应 ===================================
    public static <T> Response<T> success() {
        Response<T> response = new Response<T>();
        response.setStatus(Responsestatus.success());
        response.setCustom(ResponseCustom.setCustom());
        return response;
    }
    public static <T> Response<T> success(String m) {
        Response<T> response = new Response<T>();
        response.setStatus(Responsestatus.success(m));
        response.setCustom(ResponseCustom.setCustom());
        return response;
    }

    public static <T> Response<T> success(String m, T d) {
        Response<T> response = new Response<T>();
        response.setStatus(Responsestatus.success(m));
        response.setCustom(ResponseCustom.setCustom(d));
        return response;
    }

    // =================================== 失败响应 ===================================

    public static <T> Response<T> fail() {
        Response<T> response = new Response<T>();
        response.setStatus(Responsestatus.fail());
        response.setCustom(ResponseCustom.setCustom());
        return response;
    }
    public static <T> Response<T> fail(BizException bizException) {
        Response<T> response = new Response<T>();
        response.setStatus(Responsestatus.fail(bizException));
        response.setCustom(ResponseCustom.setCustom());
        return response;
    }

    public static <T> Response<T> fail(BizException bizException, T d) {
        Response<T> response = new Response<T>();
        response.setStatus(Responsestatus.fail(bizException));
        response.setCustom(ResponseCustom.setCustom(d));
        return response;
    }
}
