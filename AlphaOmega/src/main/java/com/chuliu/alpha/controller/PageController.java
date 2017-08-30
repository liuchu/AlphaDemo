package com.chuliu.alpha.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by chuliu on 2017/8/23.
 * Controller
 * Control requests to access pages
 */
@Controller
public class PageController {

    @RequestMapping("/home")
    public ModelAndView viewHome(){
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }

    @RequestMapping("/login")
    public ModelAndView viewLogin(){
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @RequestMapping("/profile")
    public ModelAndView viewProfile(){
        ModelAndView mav = new ModelAndView("profile");
        return mav;
    }

    @RequestMapping("/test")
    public ModelAndView viewTest(){
        ModelAndView mav = new ModelAndView("test");
        return mav;
    }


}
