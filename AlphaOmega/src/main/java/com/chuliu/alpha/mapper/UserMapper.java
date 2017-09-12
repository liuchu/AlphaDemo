package com.chuliu.alpha.mapper;

import com.chuliu.alpha.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by chuliu on 2017/9/12.
 */

@Component
public interface UserMapper {

    public int insertUser(User user);

    //Delete a category
    public void deleteUser(User user);

    //Get a category
    public User selectUser(String email);

    //Update a category
    public int updateUser(User user);

    //List all category
    public List<User> list();

    //count
    public int count();
}
