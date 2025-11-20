package com.zaxyliu.aop;

import com.zaxyliu.mapper.OperateLogMapper;
import com.zaxyliu.pojo.OperateLog;
import com.zaxyliu.utils.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect @Component @Slf4j
public class OperateLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Pointcut("@annotation(com.zaxyliu.ano.Log)")
    public void operateLogPointcut() {
    }

    @Around("operateLogPointcut()")
    public Object recordOperateLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // 执行目标方法
        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        // 组装日志对象
        OperateLog logEntity = new OperateLog();
        logEntity.setOperateEmpId(getCurrentUserId());
        logEntity.setOperateTime(LocalDateTime.now());
        logEntity.setClassName(joinPoint.getTarget().getClass().getName());
        logEntity.setMethodName(joinPoint.getSignature().getName());
        logEntity.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        logEntity.setReturnValue(result != null ? result.toString() : "void");
        logEntity.setCostTime(endTime - startTime);

        // 插入数据库
        operateLogMapper.insert(logEntity);

        return result;
    }

    /**
     * 模拟获取当前登录用户ID
     * 实际项目中可以从 ThreadLocal 或 Spring Security 获取
     */
    private Integer getCurrentUserId() {
        return CurrentHolder.getCurrentId();
    }
}
