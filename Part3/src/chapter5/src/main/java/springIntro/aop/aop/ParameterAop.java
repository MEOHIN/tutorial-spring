package springIntro.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect     // aop 로 동작한다.
@Component  // spring 에서 Component 로 관리한다.
public class ParameterAop {
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private  void cut() {}

//    메소드가 실행되기 전에 넘어가는 arg 확인
    @Before("cut()")
    public void before(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        Object[] args = joinPoint.getArgs();
        for (Object obj : args) {
            System.out.println("type: " + obj.getClass().getSimpleName());
            System.out.println("value: " + obj);
        }
    }

//    반환값 확인
    @AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        System.out.println("return obj");
        System.out.println(returnObj);
    }
}
