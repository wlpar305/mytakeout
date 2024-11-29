package com.sky.aspect;

import com.sky.annotation.AutoFill;
import com.sky.constant.AutoFillConstant;
import com.sky.context.BaseContext;
import com.sky.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class AutoFillAspect {
    @Pointcut("execution(* com.sky.mapper.*.*(..)) && @annotation(com.sky.annotation.AutoFill)")
    public void autoFillPointCut() {}

    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint joinPoint) {
        log.info("AutoFill start");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);

        OperationType operationType = autoFill.value();
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return; // 检查 args 是否为 null 或空
        }

        Object entity = args[0];
        LocalDateTime now = LocalDateTime.now();
        Long currentId = BaseContext.getCurrentId();

        if (operationType == OperationType.INSERT) {
            try {
                // 设置创建时间
                Method setCreateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_TIME, LocalDateTime.class);
                setCreateTime.invoke(entity, now);

                setOptionalMethod(entity, AutoFillConstant.SET_CREATE_USER, Long.class, currentId);
                setOptionalMethod(entity, AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class, now);
                setOptionalMethod(entity, AutoFillConstant.SET_UPDATE_USER, Long.class, currentId);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (operationType == OperationType.UPDATE) {
            try {
                // 设置更新时间
                Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
                setUpdateTime.invoke(entity, now);
                // 设置更新用户
                setOptionalMethod(entity, AutoFillConstant.SET_UPDATE_USER, Long.class, currentId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void setOptionalMethod(Object entity, String methodName, Class<?> parameterType, Object value) {
        try {
            Method method = entity.getClass().getDeclaredMethod(methodName, parameterType);
            method.invoke(entity, value);
        } catch (NoSuchMethodException e) {
            // 如果方法不存在，跳过调用
            log.warn("Method {} not found in class {}", methodName, entity.getClass().getSimpleName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

