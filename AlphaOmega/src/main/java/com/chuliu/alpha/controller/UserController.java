package com.chuliu.alpha.controller;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by chuliu on 2017/8/27.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping("/doLogin")
    public ModelAndView viewHome(HttpServletRequest request){

        logger.debug("登陆中。。。");
        String email=request.getParameter("inputEmail");
        String password=request.getParameter("inputPassword");
        String remember=request.getParameter("inputRemember");
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

        ModelAndView mav = new ModelAndView("redirect:/home");
        return mav;
    }

}
