package springIntro.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect     // aop 로 동작한다.
@Component  // spring 에서 Component 로 관리한다.
public class ParameterAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private  void cut() {}

//    메소드가 실행되기 전에 넘어가는 arg 확인
    @Before("cut()")
    public void before(JoinPoint joinPoint) {
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
