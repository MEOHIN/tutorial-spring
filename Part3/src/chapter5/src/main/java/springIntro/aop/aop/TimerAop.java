package springIntro.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {

    @Pointcut("execution(* springIntro.aop.controller..*.*(..))")
    private void cut(){}

    @Pointcut("@annotation(springIntro.aop.annoation.Timer)")
    private void enableTimer(){}

    @Around("cut() && enableTime()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();

        stopWatch.stop();

        System.out.println("total time: " + stopWatch.getTotalTimeSeconds());
    }
}
