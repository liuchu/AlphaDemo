package com.chuliu.alpha.service.impl;

import com.chuliu.alpha.dao.UserDao;
import com.chuliu.alpha.dao.impl.UserDaoImpl;
import com.chuliu.alpha.exception.UserRegisterException;
import com.chuliu.alpha.pojo.User;
import com.chuliu.alpha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by chuliu on 2017/9/12.
 * Services @User
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    UserDaoImpl userDao;

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserByEmail(String email) {

        User user = null;

        try{
            user = userDao.selectUserByEmail(email);
        }catch (DataAccessException e){
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void createUser(User user) throws UserRegisterException {
        int affectedRow = 0;

        try{
            affectedRow = userDao.insertUser(user);
        }catch (DataAccessException e){
            e.printStackTrace();
        }

        if (affectedRow==0) {
            throw new UserRegisterException("Register account failed");
        }

    }
}
