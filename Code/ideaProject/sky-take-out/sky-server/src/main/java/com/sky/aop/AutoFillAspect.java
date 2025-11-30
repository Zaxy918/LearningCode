package com.sky.aop;

import com.sky.annotation.AutoFill;
import com.sky.constant.AutoFillConstant;
import com.sky.context.BaseContext;
import com.sky.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.constant.MethodConstant;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class AutoFillAspect {
    @Pointcut("execution(* com.sky.mapper.*.*(..)) && @annotation(com.sky.annotation.AutoFill)")
    public void autoFillPointcut() {
    }

    @Before("autoFillPointcut()")
    public void beforeAutoFill(JoinPoint joinPoint) {
        log.info("AutoFillAspect beforeAutoFill executed");
        LocalDateTime now = LocalDateTime.now();
        Long currentId = BaseContext.getCurrentId();
        //Get the method being called and its parameters
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);
        OperationType operationType = autoFill.value();
        //Perform autofill logic based on the annotation's value
        if (args == null || args.length == 0) {
            return;
        }
        Object entity = args[0];
        try {
            entity.getClass().getMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class).invoke(entity, now);
            entity.getClass().getMethod(AutoFillConstant.SET_UPDATE_USER, Long.class).invoke(entity,currentId);
            if (operationType == OperationType.INSERT) {
                entity.getClass().getMethod(AutoFillConstant.SET_CREATE_TIME, LocalDateTime.class).invoke(entity, now);
                entity.getClass().getMethod(AutoFillConstant.SET_CREATE_USER, Long.class).invoke(entity, currentId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
