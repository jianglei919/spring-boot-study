package com.example.spring.study.web.handler;

import com.example.spring.study.enums.CodeEnum;
import com.example.spring.study.util.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by jianglei on 2019/12/10.
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public ApiResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException : " + e.getMessage(), e);
        return ApiResult.createResult(CodeEnum.FAILED, e.getBindingResult().getFieldError().getDefaultMessage());
    }
}
