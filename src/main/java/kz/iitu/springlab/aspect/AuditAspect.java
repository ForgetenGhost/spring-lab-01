package kz.iitu.springlab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class AuditAspect {

    @Before("@annotation(kz.iitu.springlab.annotation.Audited)")
    public void auditBefore(JoinPoint joinPoint) {
        System.out.println("[AUDIT] Method marked as @Audited is about to be called: "
                + joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* kz.iitu.springlab.service.CatalogService.*(..))",
            throwing = "ex")
    public void auditException(JoinPoint joinPoint, Throwable ex) {
        System.out.println("[AUDIT] Exception in method "
                + joinPoint.getSignature().getName() + ": " + ex.getMessage());
    }
}