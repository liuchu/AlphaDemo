package com.chuliu.alpha.realm;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by chuliu on 2017/8/15.
 * Customized Shiro Realm
 */
public class AlphaAuthorizationRealm extends AuthorizingRealm {

    private static Logger logger = Logger.getLogger(AlphaAuthorizationRealm.class);

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        logger.debug("Call doGetAuthorizationInf() method");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        logger.debug("正在进行用户验证。。。");
        logger.debug("当前用户名:"+token.getUsername());
        logger.debug("当前密码:"+String.valueOf(token.getPassword()));

        logger.debug("当前Credential;:"+token.getCredentials());
        logger.debug("当前Principal:"+token.getPrincipal());
        logger.debug("当前Host:"+token.getHost());

        return new SimpleAuthenticationInfo(token.getUsername(),token.getPassword(),getName());
    }
}
