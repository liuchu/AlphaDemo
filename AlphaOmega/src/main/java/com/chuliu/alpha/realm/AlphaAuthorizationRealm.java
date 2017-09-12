package com.chuliu.alpha.realm;

import com.chuliu.alpha.pojo.User;
import com.chuliu.alpha.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by chuliu on 2017/8/15.
 * Customized Shiro Realm
 */
public class AlphaAuthorizationRealm extends AuthorizingRealm {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private static Logger logger = Logger.getLogger(AlphaAuthorizationRealm.class);

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        logger.debug("Call doGetAuthorizationInfo() method");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        logger.debug("正在进行用户验证。。。");

        logger.debug("当前用户名:"+token.getUsername());
        logger.debug("当前密码:"+String.valueOf(token.getPassword()));

        String email = token.getUsername();
        /* 假如从数据库里查到的密码为 'abc' */
        User user = userService.getUserByEmail(email);

        logger.debug(user);

        String passFromDB = new Sha256Hash("abc",email,10).toHex();

        return new SimpleAuthenticationInfo(email,passFromDB,ByteSource.Util.bytes(email),getName());
    }

    public static void main(String[] args) {
        String passFromDB = new Sha256Hash("nlpo5689","liuchuu@126.com",10).toHex();
        System.out.println(passFromDB);
    }
}
