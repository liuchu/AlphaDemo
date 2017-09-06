package com.chuliu.alpha.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by chuliu on 2017/8/27.
 * Handle request about user
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static Logger logger = Logger.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping("/doAuthenticate")
    public String doAuthenticate(HttpServletRequest request){
        String email=request.getParameter("inputEmail");
        String password=request.getParameter("inputPassword");
        logger.debug(email+"验证中。。。");
        logger.debug("email is:"+email);
        logger.debug("password is:"+password);

        JSONObject obj = new JSONObject();


        if ("liuchuu@126.com".equals(email)) {
            obj.put("response","fail");
        }else{
            obj.put("response","success");
        }

        return obj.toJSONString();
    }

    @RequestMapping("/doLogin")
    public ModelAndView doLogin(HttpServletRequest request){

        String email=request.getParameter("inputEmail");
        String password=request.getParameter("inputPassword");
        String remember=request.getParameter("inputRemember");
        logger.debug(email+"登陆中。。。");
        logger.debug("email is:"+email);
        logger.debug("password is:"+password);
        logger.debug("remember is:"+remember);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(email);
        token.setPassword(password.toCharArray());

        try{
            subject.login(token);

        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
        }

        Session session = subject.getSession();
        logger.debug("Time out:"+session.getTimeout());

        ModelAndView mav = new ModelAndView("redirect:/home");
        return mav;
    }

    @RequestMapping("/doLogout")
    public ModelAndView doLogout(HttpServletRequest request){

        logger.debug("退出中。。。");

        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();

        subject.logout();

        ModelAndView mav = new ModelAndView("redirect:/home");
        return mav;
    }

    @RequestMapping("/changeLanguage")
    public ModelAndView changeLanguage(HttpServletRequest request, String lang){

        logger.debug("切换语言中。。。当前语言为:"+lang);

        ModelAndView mav = new ModelAndView("redirect:/profile");
        return mav;
    }



}
