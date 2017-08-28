package com.chuliu.alpha.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by chuliu on 2017/8/28.
 * Define all point cuts
 */
@Aspect
public class PointCuts {

    //all Controller public methods
    @Pointcut("execution(public * com.chuliu.alpha.controller.*.*(..))")
    public void allController(){
    }
}
