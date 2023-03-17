package com.luxoft.springaop.example2;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

//    @Around("@annotation(com.luxoft.springaop.example2.Log)")
    @Around("@annotation(log)")
    public Object log(ProceedingJoinPoint thisJoinPoint, Log log) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();

        if (log.printArgs()) {
            logger.info("CALL METHOD " + methodName + " with args " + methodArgs);
        }

        Object result = thisJoinPoint.proceed();

        logger.info("METHOD " + methodName + " returns " + result);

        return result;
    }
    @Around("@within(log)")
    public Object log1(ProceedingJoinPoint thisJoinPoint, Log log) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();

        if (log.printArgs()) {
            logger.info("CALL METHOD1 " + methodName + " with args1 " + methodArgs);
        }

        Object result = thisJoinPoint.proceed();

        logger.info("METHOD1 " + methodName + " returns1 " + result);

        return result;
    }
}
