package com.zaxyliu.exception;

import com.zaxyliu.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handleException(Exception e) {
         log.error("Something wrong", e);
         return Result.error("Something wrong");
    }

    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        log.error("Something wrong" , e);
        String msg = e.getMessage();
        return Result.error(msg.substring(msg.indexOf("Duplicate entry")).split(" ")[2] + " is already in database.");
    }
}
