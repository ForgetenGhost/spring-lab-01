package kz.iitu.springlab.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class TimingAspect {

    @Around("execution(* kz.iitu.springlab.service.CatalogService.*(..))")
    public Object measureTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = pjp.proceed();   // выполняем реальный метод

        long duration = System.currentTimeMillis() - start;
        System.out.println("[TIME] Method " + pjp.getSignature().getName()
                + " took " + duration + " ms");

        return result;
    }
}