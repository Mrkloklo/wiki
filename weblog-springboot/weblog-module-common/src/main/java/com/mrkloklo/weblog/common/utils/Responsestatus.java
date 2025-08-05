package com.mrkloklo.weblog.common.utils;

import java.io.Serializable;

import lombok.Data;

/**
 * @author: gujhao
 * @date: 2025-08-05 16:30
 * @description:
 **/
@Data
public class Responsestatus<T> implements Serializable {
    // 是否成功，默认1
    private Integer code = 1;
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
        responsestatus.setCode(0);
        responsestatus.setMessage("请求失败");
        return responsestatus;
    }

    public static <T> Responsestatus<T> fail(String message) {
        Responsestatus<T> responsestatus = new Responsestatus<T>();
        responsestatus.setCode(0);
        responsestatus.setMessage(message);
        return responsestatus;
    }
}
