package com.luxoft.springaop.example6;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class ArgsAspect {

    @Pointcut("args(int, ..)")
    public void firstInt() {
    }

    @Pointcut("args(*,*, int, ..)")
    public void secondInt() {
    }

    @Pointcut("args(*, *, int, ..)")
    public void thirdInt() {
    }

    @Pointcut("@args(com.luxoft.springaop.example2.Log)")
    public void oneLoggable() {
    }

    @Around("firstInt() || secondInt() || thirdInt()")
    public Object test( ProceedingJoinPoint jp) {

        String type = jp.getSignature().getDeclaringTypeName();
        String methodName = jp.getSignature().getName();
        Object[] methodArgs = jp.getArgs();

        print("ARGS LOG: CALL METHOD " + type + "#" + methodName + " with args " + Arrays.toString(methodArgs));

        return null;
    }

    @Around("oneLoggable()")
    public Object testLoggable(ProceedingJoinPoint jp) {

        String type = jp.getSignature().getDeclaringTypeName();
        String methodName = jp.getSignature().getName();
        Object[] methodArgs = jp.getArgs();

        print("@ARGS LOG: CALL METHOD " + type + "#" + methodName + " with args " + Arrays.toString(methodArgs));

        return null;
    }

    private void print(String toLog) {
        System.out.println(toLog);
    }
}
