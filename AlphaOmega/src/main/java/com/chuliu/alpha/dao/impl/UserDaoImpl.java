package com.chuliu.alpha.dao.impl;

import com.chuliu.alpha.dao.UserDao;
import com.chuliu.alpha.mapper.UserMapper;
import com.chuliu.alpha.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by chuliu on 2017/9/12.
 * Database action about @User
 */

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    UserMapper userMapper;


    @Override
    public User selectUserByEmail(String email) {
        User user = userMapper.selectUser("liuchuu@126.com");
        return user;
    }

    @Override
    public void insertUser(User user) {

    }


}
