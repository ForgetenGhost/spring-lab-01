package kz.iitu.springlab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LoggingAspect {

    @Pointcut("execution(* kz.iitu.springlab.service.CatalogService.*(..))")
    public void catalogServiceMethods() {}

    @Before("catalogServiceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[LOG] → Entering method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "catalogServiceMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("[LOG] ← Method " + joinPoint.getSignature().getName()
                + " returned: " + result);
    }
}