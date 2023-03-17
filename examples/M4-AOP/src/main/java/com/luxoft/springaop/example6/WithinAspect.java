package com.luxoft.springaop.example6;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
public class WithinAspect {
    private static final Logger LOGGER = Logger.getLogger(WithinAspect.class.getName());


    @Pointcut("within(com.luxoft.springaop.example6.within.*)")

    public void allBeans() {
    }

    @Pointcut("@within(com.luxoft.springaop.example2.Log)")

    public void allBeansWithAnnotation() {
    }

    @Around("allBeans()")
    public Object testAllBeans(ProceedingJoinPoint jp) throws Throwable {
        jp.proceed();
        String type = jp.getSignature().getDeclaringTypeName();
        String methodName = jp.getSignature().getName();
        Object[] methodArgs = jp.getArgs();

        print("WITHIN LOG: CALL METHOD " + type + "#" + methodName + " with args " + Arrays.toString(methodArgs));

        return null;
    }

   // @Order(1)
    @Around("allBeansWithAnnotation()")
    public Object testAllBeansWithAnnotation(ProceedingJoinPoint jp) throws Throwable {

        jp.proceed();
        String type = jp.getSignature().getDeclaringTypeName();
        String methodName = jp.getSignature().getName();
        Object[] methodArgs = jp.getArgs();

        print("WITHIN ANNOTATION LOG: CALL METHOD " + type + "#" + methodName + " with args " + Arrays.toString(methodArgs));

        return null;
    }

    private void print(String toLog) {
        System.out.println(toLog);
    }
}
