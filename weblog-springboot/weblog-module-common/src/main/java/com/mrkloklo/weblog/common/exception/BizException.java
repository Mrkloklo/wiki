package com.mrkloklo.weblog.common.exception;


import lombok.Getter;
import lombok.Setter;

/**
 * @author: gujhao
 * @date: 2025-08-06 16:52
 * @description:业务异常
 **/
@Getter
@Setter
public class BizException extends RuntimeException {
    private String errorCode;
    private String errorMessage;

    public BizException(BaseExceptionInterface baseExceptionInterface) {
        this.errorCode = baseExceptionInterface.getErrorCode();
        this.errorMessage = baseExceptionInterface.getErrorMessage();
    }
}
