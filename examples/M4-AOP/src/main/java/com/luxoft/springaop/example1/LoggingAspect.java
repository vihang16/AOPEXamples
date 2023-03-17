package com.luxoft.springaop.example1;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect

public class LoggingAspect {


    @Pointcut("execution(* *.*User(..))")

    public void gdfhhd() {
        System.out.println(" --> never called ");
    }
    @Around("gdfhhd()")
    public Object yrjtrd(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();

        print("LOG: CALL METHOD1 " + methodName + " with args1 " + Arrays.toString(methodArgs));

        Object result = thisJoinPoint.proceed();
        //Object result = null;

        print("LOG: METHOD 1 " + methodName + " returns1 " + result);

        return result;
    }










    private void print(String toLog) {
        System.out.println(toLog);
    }

}
