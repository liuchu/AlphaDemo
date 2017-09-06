package com.chuliu.alpha.controller;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by chuliu on 2017/8/22.
 * Handle request about issue
 */
@Controller
@RequestMapping("/issue")
public class IssueController {

    private static Logger logger = Logger.getLogger(IssueController.class);

    @RequestMapping("/doCreate")
    public ModelAndView doCreate(HttpServletRequest request){

        logger.debug("创建话题中。。。");

        ModelAndView mav = new ModelAndView("redirect:/issues");
        return mav;
    }
}
