package com.chuliu.alpha.service;

import com.chuliu.alpha.exception.UserRegisterException;
import com.chuliu.alpha.pojo.Group;
import com.chuliu.alpha.pojo.User;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by chuliu on 2017/9/12.
 */

public interface UserService {

    //根据email获取一个用户的信息
    User getUserByEmail(String email);

    //创建一个用户
    void createUser(User user) throws UserRegisterException;

    //获取用户拥有的权限

    //获取用户所在的组(角色)
    Set<Group> getGroups(String email);

    //获取用户所拥有的权限
    Set<String> getStringPermissions(String email);
}
