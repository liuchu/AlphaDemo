package com.chuliu.alpha.dao;

import com.chuliu.alpha.pojo.User;
import org.springframework.dao.DataAccessException;

/**
 * Created by chuliu on 2017/9/12.
 * Database action about @User
 */
public interface UserDao {

    //从数据库查询一条用户记录
    User selectUserByEmail(String email) throws DataAccessException;

    //往数据库插入一条记录
    int insertUser(User user) throws DataAccessException;

}
