package com.chuliu.alpha.controller;

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
        System.out.println("IN PageController");
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }
}
