package com.chuliu.alpha.dao;

import com.chuliu.alpha.pojo.User;

/**
 * Created by chuliu on 2017/9/12.
 * Database action about @User
 */
public interface UserDao {

    //从数据库查询一条用户记录
    User selectUserByEmail(String email);

    //往数据库插入一条记录
    void insertUser(User user);

}
