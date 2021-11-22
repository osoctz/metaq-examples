package cn.metaq.example.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class CreatedByAop {

  @Around("execution(* cn.metaq.identity.web.UserController.add(..))")
  public Object around2(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

    Object[] args=proceedingJoinPoint.getArgs();
//    args[0]="admin";

    log.info("拦截controller:{}",args);
    return proceedingJoinPoint.proceed(args);
  }
}
