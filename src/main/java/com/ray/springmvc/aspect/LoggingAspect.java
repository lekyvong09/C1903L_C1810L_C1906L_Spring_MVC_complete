package com.ray.springmvc.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    // setup Logger
    private static final Logger myLogger = LogManager.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.ray.springmvc.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.ray.springmvc.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("execution(* com.ray.springmvc.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forLoggingAspect() {}

    @Before("forLoggingAspect()")
    public void beforeLogging(JoinPoint theJoinPoint) {
        myLogger.info("===> in @Before advice: calling method: " + theJoinPoint.getSignature().toShortString());

        Object[] args = theJoinPoint.getArgs();
        for (Object tempArg : args) {
            myLogger.info("===> argument: " + tempArg);
        }
    }
}
