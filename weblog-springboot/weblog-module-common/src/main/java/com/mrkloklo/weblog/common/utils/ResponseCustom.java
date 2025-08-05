package com.mrkloklo.weblog.common.utils;


import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author: gujhao
 * @date: 2025-08-05 16:31
 * @description:
 **/
@Data
public class ResponseCustom<T> implements Serializable {

    private T data;

    /**
     * 创建默认ResponseCustom，data为{}
     */
    public static <T> ResponseCustom<T> setCustom() {
        ResponseCustom<T> res = new ResponseCustom<>();
        // 使用空Map作为默认值，序列化后为{}
        // 强制转换为T时添加抑制警告注解
        @SuppressWarnings("unchecked")
        T defaultData = (T) new HashMap<>();
        res.setData(defaultData);
        return res;
    }

    /**
     * 带自定义data的创建方法
     */
    public static <T> ResponseCustom<T> setCustom(T data) {
        ResponseCustom<T> res = new ResponseCustom<>();
        res.setData(data);
        return res;
    }

}
