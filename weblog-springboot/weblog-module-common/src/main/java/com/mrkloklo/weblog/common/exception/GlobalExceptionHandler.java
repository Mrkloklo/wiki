package com.mrkloklo.weblog.common.exception;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrkloklo.weblog.common.enums.ResponseCodeEnum;
import com.mrkloklo.weblog.common.utils.Response;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: gujhao
 * @date: 2025-08-06 17:04
 * @description:全局异常类处理
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获自定义业务异常
     * 
     * @return
     */
    @ExceptionHandler({BizException.class})
    @ResponseBody
    public Response<Object> handleException(HttpServletRequest r, BizException e) {
        log.warn("{} request faile,errorCode:{},errorMessage:{}", r.getRequestURI(), e.getErrorCode(),
            e.getErrorMessage());
        return Response.fail(e);
    }

    /**
     * 其他类型异常
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Response<Object> handleOtherException(HttpServletRequest request, Exception e) {
        log.error("{} request error, ", request.getRequestURI(), e);
        return Response.fail();
    }

    /**
     * 捕获参数校验异常
     * 
     * @return
     */

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public Response<Object> handleMethodArgumentNotValidException(HttpServletRequest r,
        MethodArgumentNotValidException e) {
        String errCode = ResponseCodeEnum.PARAM_NOT_VALID.getErrorCode();

        BindingResult bindingResult = e.getBindingResult();
        StringBuilder sb = new StringBuilder();

        Optional.ofNullable(bindingResult.getFieldErrors()).ifPresent(errors -> {
            errors.forEach(error -> sb.append(" ").append(error.getDefaultMessage()).append("，当前值：'")
                .append(error.getRejectedValue()).append("';"));

        });
        String errMsg = sb.toString();

        log.warn("{} request error, errorCode: {}, errorMessage: {}", r.getRequestURI(), errCode, errMsg);


        return Response.fail(errCode,errMsg);
    }

}
