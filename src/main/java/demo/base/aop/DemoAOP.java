package demo.base.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DemoAOP {
    @Before("execution(* demo.base.aop.*.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("will call " + method.getName());
    }

    @After("execution(* demo.base.aop.DemoService.*(..))")
    public void after(JoinPoint joinPoint) {
        System.out.println("after call...");
    }
}
