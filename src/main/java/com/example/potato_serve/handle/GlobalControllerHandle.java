package com.example.potato_serve.handle;

import com.example.potato_serve.config.ResCodeEnum;
import com.example.potato_serve.utils.DataWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice(basePackages = "com.example.potato_serve.controller")
public class GlobalControllerHandle implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(
            Object body,
            MethodParameter returnType,
            MediaType selectedContentType,
            Class selectedConverterType,
            ServerHttpRequest request,
            ServerHttpResponse response
    ) {
        if (body instanceof DataWrapper) {
            return body;
        }

        DataWrapper result = new DataWrapper();
        result.setData(body);

        return result;
    }

    /**
     * 默认全局异常处理。
     * @param e the e
     * @return ResultData
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object exception(Exception e) {
        log.error("全局异常信息 ex={}", e.getMessage(), e);
//        System.out.print("全局异常信息 : " + e.getMessage());

        DataWrapper result = new DataWrapper();
        result.setCode(ResCodeEnum.ERROR.getCode());
        result.setMessage(e.getMessage());

        return result;
    }

    // <1> 处理 form data方式调用接口校验失败抛出的异常
    @ExceptionHandler(BindException.class)
    public Object bindExceptionHandle(BindException e) {
        List<FieldError> fieldError = e.getBindingResult().getFieldErrors();
        List<String> collect = fieldError
                .stream()
                .map(o -> o.getDefaultMessage())
                .collect(Collectors.toList());

        DataWrapper result = new DataWrapper();
        result.setWarning(ResCodeEnum.WARNING.getCode(), "校验失败", collect);
        log.error("参数校验失败 ex={}", e.getMessage(), e);

        return result;
    }

    // <2> 处理 json 请求体调用接口校验失败抛出的异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> collect = fieldErrors.stream()
                .map(o -> o.getDefaultMessage())
                .collect(Collectors.toList());

        DataWrapper result = new DataWrapper();
        result.setWarning(ResCodeEnum.WARNING.getCode(), "校验失败", collect);
        log.error("参数校验失败 ex={}", e.getMessage(), e);

        return result;
    }

    // <3> 处理单个参数校验失败抛出的异常
    @ExceptionHandler(ConstraintViolationException.class)
    public Object constraintViolationExceptionHandler(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        List<String> collect = constraintViolations.stream()
                .map(o -> o.getMessage())
                .collect(Collectors.toList());

        DataWrapper result = new DataWrapper();
        result.setWarning(ResCodeEnum.WARNING.getCode(), "校验失败", collect);
        log.error("参数校验失败 ex={}", e.getMessage(), e);

        return result;
    }
}
