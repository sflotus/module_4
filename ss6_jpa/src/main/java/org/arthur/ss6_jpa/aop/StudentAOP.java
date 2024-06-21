package org.arthur.ss6_jpa.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class StudentAOP {
    @Before(" execution(* org.arthur.ss6_jpa.controller.StudentController.*(..))")
    public void beforeShowCreateForm(JoinPoint joinPoint){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Access: " + joinPoint.getSignature().getName() + " At: " + localDateTime);
    }
//    @After(" execution(* org.arthur.ss6_jpa.controller.StudentController.*(..))")
//    public void afterShowCreateForm(JoinPoint joinPoint){
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println("Quit: " +  joinPoint.getSignature().getName() + " At: " + localDateTime);
//     
//    }
}
