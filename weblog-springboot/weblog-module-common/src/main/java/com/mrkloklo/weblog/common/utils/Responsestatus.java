package com.mrkloklo.weblog.common.utils;

import java.io.Serializable;

import com.mrkloklo.weblog.common.enums.ResponseCodeEnum;
import com.mrkloklo.weblog.common.exception.BizException;
import lombok.Data;

/**
 * @author: gujhao
 * @date: 2025-08-05 16:30
 * @description:
 **/
@Data
public class Responsestatus<T> implements Serializable {
    // 是否成功，默认1
    private String code = "1";
    // 响应消息
    private String message;

    // =================================== 成功响应 ===================================

    public static <T> Responsestatus<T> success() {
        Responsestatus<T> responsestatus = new Responsestatus<T>();
        responsestatus.setMessage("请求成功");
        return responsestatus;
    }

    public static <T> Responsestatus<T> success(String message) {
        Responsestatus<T> responsestatus = new Responsestatus<T>();
        responsestatus.setMessage(message);
        return responsestatus;
    }

    // =================================== 失败响应 ===================================
    public static <T> Responsestatus<T> fail() {
        Responsestatus<T> responsestatus = new Responsestatus<T>();
        responsestatus.setCode(ResponseCodeEnum.SYSTEM_ERROR.getErrorCode());
        responsestatus.setMessage(ResponseCodeEnum.SYSTEM_ERROR.getErrorMessage());
        return responsestatus;
    }

    public static <T> Responsestatus<T> fail(BizException  bizException) {
        Responsestatus<T> responsestatus = new Responsestatus<T>();
        responsestatus.setCode(bizException.getErrorCode());
        responsestatus.setMessage(bizException.getErrorMessage());
        return responsestatus;
    }
}
