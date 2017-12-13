package com.chuliu.alpha.dao;

import com.chuliu.alpha.pojo.Group;
import com.chuliu.alpha.pojo.User;
import org.springframework.dao.DataAccessException;

import java.util.Set;

/**
 * Created by chuliu on 2017/9/12.
 * Database action about @User
 */
public interface UserDao {

    //从数据库查询一条用户记录
    //@Parameters: user's email
    //@Return: user pojo
    User selectUserByEmail(String email) throws DataAccessException;

    //往数据库插入一条记录
    //@Parameters: user pojo
    //@Return: user pojo
    int insertUser(User user) throws DataAccessException;

    //由组的id查询组名
    //@Parameters: group's id
    //@Return: group POJO
    Group selectGroupById(long id) throws DataAccessException;

    //查询用户所在的所有组
    //@Parameters: group's id
    //@Return: group POJO
    Set<Long> selectGroupsOfUser(String email) throws DataAccessException;

}
