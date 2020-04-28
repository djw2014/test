package com.djw.edu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Base64;

/**
 * @Author djw
 * @Description //TODO
 * @Date 2020/4/28 10:10
 */
@Aspect
@Component
public class AopConfig {
    /**
     * 匹配AopTestController下的所有方法
     */
    @Pointcut("execution(* com.djw.edu.controller.AopTestController.*(..))")
    public void methodCut() {

    }

    /**
     * 匹配带有@Djw注解的方法
     */
    @Pointcut("@annotation(com.djw.edu.annotation.Djw)")
    public void annotationCut() {

    }

    /**
     * 在方法执行之前先进行此步操作
     *
     * @param joinPoint
     */
//    @Before("methodCut()")
    public void changeValues(JoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //得到拦截的方法
        Method method = signature.getMethod();
        System.out.println("方法名：" + method.getName());
        //获取参数的值
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            if (args[i] != null && !"".equals(args[i])) {
                System.out.println("-------------------------");
                System.out.println("转换前：" + args[i]);
                args[i] = new String(Base64.getDecoder().decode(String.valueOf(args[i])));
                System.out.println("转换后：" + args[i]);
            }
        }
    }
}
