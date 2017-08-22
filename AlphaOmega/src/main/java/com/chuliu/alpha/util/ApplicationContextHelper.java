package com.chuliu.alpha.util;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by chuliu on 2017/8/16.
 * This tool can get ApplicationContext from everywhere
 */
public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext context;



    public static ApplicationContext getApplicationContext(){
        return context;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
