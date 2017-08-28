package com.chuliu.alpha.aspect;

import com.chuliu.alpha.controller.UserController;
import com.chuliu.alpha.util.ApplicationContextHelper;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneId;


/**
 * Created by chuliu on 2017/8/22.
 * Logger Aspect
 */

@Component("loggerAspect")
@Aspect
public class LoggerAspect {

    private static Logger logger = Logger.getLogger(LoggerAspect.class);

    @Before(value = "com.chuliu.alpha.aspect.PointCuts.allController()")
    public void logStartTime(){

        logger.info("[loggerAspect]start time:"+ LocalDateTime.now());
    }

    @After(value = "com.chuliu.alpha.aspect.PointCuts.allController()")
    public void logEndTime(){
        logger.info("[loggerAspect]end time:"+ LocalDateTime.now());
    }

    @Around(value = "com.chuliu.alpha.aspect.PointCuts.allController()")
    public Object logRequest(ProceedingJoinPoint joinPoint) throws Throwable {

        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;
        HttpServletRequest request = sra.getRequest();

        //从Shiro中获取用户信息
        Subject subject = SecurityUtils.getSubject();
        Object pricipal = null;

        if(subject.isAuthenticated()){
            pricipal = subject.getPrincipal();
            System.out.println("Principle:"+pricipal);
        }else{
            pricipal = "匿名用户" ;
        }
        // 获取输入参数
        //inputParamMap = request.getParameterMap();
        // 获取请求地址
        String requestPath = request.getRequestURI();

        logger.info(pricipal+" is requesting: "+requestPath);

        // 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行
        Object result = joinPoint.proceed();// result的值就是被拦截方法的返回值

        return result;

    }
}
