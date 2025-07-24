package com.mrkloklo.weblog.web.controller;


import com.mrkloklo.weblog.common.aspect.ApiOperationLog;
import com.mrkloklo.weblog.web.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

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
    public User test(@RequestBody User user){
        //返回参数
        return user;
    }
    @PostMapping("/testentity")
    @ApiOperationLog(description = "测试校验")
    public ResponseEntity<String> testEntity(@RequestBody @Validated User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            // 获取校验不通过字段的提示信息
            String errorMsg = bindingResult.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));

            return ResponseEntity.badRequest().body(errorMsg);
        }
        return ResponseEntity.ok("参数没有任何问题");
    }
}
