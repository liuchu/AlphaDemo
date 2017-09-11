package com.chuliu.alpha.pojo;

import com.chuliu.alpha.pojo.relation.UserGroupItem;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by chuliu on 2017/8/22.
 * pojo User
 */
public class User {

    //基本信息
    private long id;

    private String email;
    private String displayName;
    private String password;

    //注册时间
    private LocalDateTime registerTime;
    private LocalDateTime lastLoginTime;

    //持有金币数
    private long coin;

    //是否是活跃状态
    private boolean active;

    private List<UserGroupItem> userGroupItemList;

}
