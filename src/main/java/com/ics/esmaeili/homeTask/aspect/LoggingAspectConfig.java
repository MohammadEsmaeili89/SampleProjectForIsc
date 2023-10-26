package com.ics.esmaeili.homeTask.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Aspect
@Slf4j
@Configuration
public class LoggingAspectConfig {

    @Pointcut("within(@org.springframework.stereotype.Repository *)"
            + " || within(@org.springframework.stereotype.Service *)"
            + " || within(@org.springframework.web.bind.annotation.RestController *)")
    public void springBeanPointcut() {
        throw new UnsupportedOperationException();
    }

    @Pointcut("within(com.ics.esmaeili.homeTask.repository..*)"
            + " || within(com.ics.esmaeili.homeTask.service.impl..*)"
            + " || within(com.ics.esmaeili.homeTask.controller..*)")
    public void applicationPackagePointcut() {
        throw new UnsupportedOperationException();
    }

    @AfterThrowing(pointcut = "applicationPackagePointcut() && springBeanPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), e.getCause() != null ? e.getMessage() : "NULL");
    }

    @Around("applicationPackagePointcut() && springBeanPointcut()")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        final String joinPoints = Arrays.toString(joinPoint.getArgs());
        if (joinPoints != null) {
            log.info("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), joinPoints);
        }
        final Object result = joinPoint.proceed();
        log.info("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), result);
        return result;
    }

}
