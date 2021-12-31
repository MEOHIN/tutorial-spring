package springIntro.aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* springIntro.aop.controller..*.*(..))")
    private void cut(){}

    @Pointcut("@annotation(springIntro.aop.annotation.Decode)")
    private void enableDecode(){}
}
