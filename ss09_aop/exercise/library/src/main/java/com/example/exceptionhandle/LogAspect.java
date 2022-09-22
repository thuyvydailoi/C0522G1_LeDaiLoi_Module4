package com.example.exceptionhandle;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LogAspect {
    int count = 0;

    @Pointcut("within (com.example.controller.*)")
    public void allMethod(){
    }

    @Pointcut("execution(* com.example.controller.BookController.get*(..))")
    public void changeBook(){
    }

    @AfterReturning("changeBook()")
    public void afterChangeBook(JoinPoint joinPoint){
        System.out.println("End change book: " + joinPoint.getSignature().getName() + "Time" + LocalDateTime.now());
    }

    @AfterReturning("allMethod()")
    public void afterCallMethod(JoinPoint joinPoint){
        count++;
        System.out.println("Số người thao tác với thư viện: " + count);
    }

}
