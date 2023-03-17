package com.luxoft.springaop.example1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Aspect

public class LoggingAspect2 {

    @Pointcut("execution(* *.*User(..))")

    public void userMethod() {
        System.out.println(" --> never called ");
    }

    @Around("userMethod()")
    public Object log(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();

        print("LOG: CALL METHOD " + methodName + " with args " + Arrays.toString(methodArgs));

        Object result = thisJoinPoint.proceed();


        print("LOG: METHOD  " + methodName + " returns " + result);

        return result;
    }
    private void print(String toLog) {
        System.out.println(toLog);
    }
}
