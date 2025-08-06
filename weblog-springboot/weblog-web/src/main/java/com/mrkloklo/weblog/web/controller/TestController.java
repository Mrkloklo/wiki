package com.mrkloklo.weblog.web.controller;

import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrkloklo.weblog.common.aspect.ApiOperationLog;
import com.mrkloklo.weblog.common.enums.ResponseCodeEnum;
import com.mrkloklo.weblog.common.exception.BizException;
import com.mrkloklo.weblog.common.utils.Response;
import com.mrkloklo.weblog.web.model.User;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: gujhao
 * @date: 2025-07-23 14:50
 * @description:/test接口
 **/
@RestController
@Slf4j
public class TestController {
    @PostMapping("/test")
    @ApiOperationLog(description = "测试接口")
    public User test(@RequestBody User user) {
        // 返回参数
        return user;
    }

    @PostMapping("/testentity")
    @ApiOperationLog(description = "测试校验")
    public Response testentity(@RequestBody @Validated User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // 获取校验不通过字段的提示信息
            String errorMsg = bindingResult.getFieldErrors().stream().map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(","));

            // return Response.fail(errorMsg);
        }
        return Response.success("请求成功", user);
    }

    @PostMapping("/testexception")
    @ApiOperationLog(description = "测试全局抛出异常")
    public Response testexception(@RequestBody @Validated User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // 手动抛异常，入参是前面定义好的异常码枚举，返参统一交给全局异常处理器搞定
            throw new BizException(ResponseCodeEnum.PRODUCT_NOT_FOUND);
        }
        return Response.success("请求成功", user);
    }

    @PostMapping("/testexception2")
    @ApiOperationLog(description = "测试全局抛出其他异常")
    public Response testexception2(@RequestBody @Validated User user, BindingResult bindingResult) {
       int i = 1/0;
        return Response.success("请求成功", user);
    }
}
