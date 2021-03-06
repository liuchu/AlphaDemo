package com.chuliu.alpha.controller;

import com.alibaba.fastjson.JSONObject;
import com.chuliu.alpha.exception.UserRegisterException;
import com.chuliu.alpha.pojo.User;
import com.chuliu.alpha.realm.AlphaAuthorizationRealm;
import com.chuliu.alpha.service.UserService;
import com.chuliu.alpha.service.impl.UserServiceImpl;
import com.chuliu.alpha.util.ApplicationContextHelper;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.List;

/**
 * Created by chuliu on 2017/8/27.
 * Handle request about user
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    //
    static ApplicationContext context = ApplicationContextHelper.getApplicationContext();

    AlphaAuthorizationRealm realm;
    private static Logger logger = Logger.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping("/doAuthenticate")
    public String doAuthenticate(HttpServletRequest request){

        //将UserService传递给shiro的reaml
        if(realm==null){
            ApplicationContext context = ApplicationContextHelper.getApplicationContext();
            logger.debug("BEGIN context:"+context);
            realm = (AlphaAuthorizationRealm)context.getBean("myRealm");
            logger.debug("BEGIN realm:"+realm);
        }
        realm.setUserService(userService);

        String email=request.getParameter("inputEmail");
        String password=request.getParameter("inputPassword");
        logger.debug(email+"验证中。。。");
        logger.debug("email is:"+email);
        logger.debug("password is:"+password);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(email);
        token.setPassword(password.toCharArray());

        JSONObject obj = new JSONObject();

        try{
            subject.login(token);
            obj.put("response","success");
        }catch (IncorrectCredentialsException e){
            //e.printStackTrace();
            logger.info(email+"登陆失败");
            obj.put("response","fail");
        }

        return obj.toJSONString();
    }

    @RequestMapping("/doLogin")
    public ModelAndView doLogin(HttpServletRequest request){

        /*String email=request.getParameter("inputEmail");
        String password=request.getParameter("inputPassword");

        logger.debug(email+"登陆中。。。");
        logger.debug("email is:"+email);
        logger.debug("password is:"+password);
        logger.debug("remember is:"+remember);*/

        String remember=request.getParameter("inputRemember");

        //如果记住则把session超时设成10天, 默认为2小时
        if ("yes".equals(remember))
            SecurityUtils.getSubject().getSession().setTimeout(1000*60*60*24*10);

        ModelAndView mav = new ModelAndView("redirect:/home");
        return mav;
    }

    @RequestMapping("/doLogout")
    public ModelAndView doLogout(HttpServletRequest request){

        logger.debug("退出中。。。");

        Subject subject = SecurityUtils.getSubject();

        subject.logout();

        ModelAndView mav = new ModelAndView("redirect:/home");
        return mav;
    }

    @ResponseBody
    @RequestMapping("/checkUsername")
    public String checkUsername(HttpServletRequest request){
        String email = request.getParameter("signUpEmail");

        logger.debug("检查用户是否存在。。。");

        JSONObject obj = new JSONObject();

        User user = userService.getUserByEmail(email);

        if(user!=null){
            obj.put("response","yes");
            logger.debug(email+"不存在。。。");
        }else {
            obj.put("response","no");
            logger.debug(email+"存在。。。");
        }

        return obj.toJSONString();
    }

    @RequestMapping("/doSignUp")
    public ModelAndView doSignUp(HttpServletRequest request){

        JSONObject result = new JSONObject();

        String email = request.getParameter("signUpEmail");
        String displayName = request.getParameter("displayName");
        String password = request.getParameter("signUpPassword");

        SimpleHash hash = new SimpleHash("sha-256", password, email, 10);
        String encodedPassword = hash.toHex();

        //UTC标准时间
        LocalDateTime registerTime = LocalDateTime.now(ZoneId.of("Europe/London"));

        logger.debug("注册中。。。");

        //User user = (User)context.getBean("user");
        User user = new User();

        logger.debug("当前注册用户:"+user);

        int affectedRow = 0;

        if (user != null) {
            user.setEmail(email);
            user.setDisplayName(displayName);
            user.setPassword(encodedPassword);
            user.setRegisterTime(registerTime);

            try {
                userService.createUser(user);
                ModelAndView mav = new ModelAndView("redirect:/home");
                logger.debug(email+"注册成功");
                return mav;
            } catch (UserRegisterException e) {
                e.printStackTrace();
                ModelAndView mav = new ModelAndView("forward:/error");

                request.setAttribute("exceptionMessage",e.getMessage());

                logger.debug(email+"注册失败");
                return mav;
            } finally {
                logger.debug("");
            }

        }

        //Default
        ModelAndView mav = new ModelAndView("redirect:/sign");
        return mav;
    }

    @RequestMapping("/changeLanguage")
    public ModelAndView changeLanguage(HttpServletRequest request, String lang){

        logger.debug("切换语言中。。。当前语言为:"+lang);

        ModelAndView mav = new ModelAndView("redirect:/profile");
        return mav;
    }

    public static void main(String[] args) {
        SimpleHash hash = new SimpleHash("sha-256", "admin", "admin@admin.com", 10);
        String encodedPassword = hash.toHex();
        System.out.println(encodedPassword);
    }



}
