package com.chuliu.alpha.mapper;

import com.chuliu.alpha.pojo.Group;
import com.chuliu.alpha.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * Created by chuliu on 2017/9/12.
 */

@Component
public interface UserMapper {

    public int insertUser(User user);

    //Delete a category
    public void deleteUser(long userId);

    //Get a user
    public User selectUser(String email);

    //Update a user
    public int updateUser(User user);

    //List all users
    public List<User> list();

    //count
    public int count();

    //get group name by its id
    public Group selectGroupById(long id);

    //get groups id of a user
    public Set<Long> selectGroupsOfUser(long userId);


}
