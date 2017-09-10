package com.chuliu.alpha.pojo;

import java.time.LocalDateTime;

/**
 * Created by chuliu on 2017/8/22.
 */
public class User {

    private long id;
    private String username;
    private String displayName;
    private String email;

    private LocalDateTime registerTime;
    private LocalDateTime lastLoginTime;

    private boolean active;

}
