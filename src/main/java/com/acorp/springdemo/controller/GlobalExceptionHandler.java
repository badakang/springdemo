package com.acorp.springdemo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ArithmeticException.class)
    public Map<String, String> handleArithMathicException(ArithmeticException e) {
        Map res = new HashMap();
        res.put("errorMsg", e.getMessage());
        res.put("status", "error");
        return res;
    }

    @ExceptionHandler(value = Exception.class)
    public Map<String, String> handelerException(Exception e) {
        Map res = new HashMap();
        res.put("errorMsg", e.getMessage());
        res.put("status", "error");
        return res;
    }
}
