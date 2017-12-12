package com.chuliu.alpha.dao.impl;

import com.chuliu.alpha.dao.UserDao;
import com.chuliu.alpha.mapper.UserMapper;
import com.chuliu.alpha.pojo.User;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
    public User selectUserByEmail(String email) throws DataAccessException {

        User user = userMapper.selectUser(email);
        return user;
    }

    @Override
    public int insertUser(User user) throws DataAccessException{

        int affectedRow = userMapper.insertUser(user);
        return affectedRow;
    }

    public static void main(String[] args) {

    }


}
