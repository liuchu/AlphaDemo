package com.chuliu.alpha.dao.impl;

import com.chuliu.alpha.dao.UserDao;
import com.chuliu.alpha.mapper.UserMapper;
import com.chuliu.alpha.pojo.Group;
import com.chuliu.alpha.pojo.User;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.Set;

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

    @Override
    public Group selectGroupById(long id) throws DataAccessException {
        return null;
    }

    @Override
    public Set<Long> selectGroupsOfUser(String email) throws DataAccessException {
        return null;
    }

    public static void main(String[] args) {

    }


}
