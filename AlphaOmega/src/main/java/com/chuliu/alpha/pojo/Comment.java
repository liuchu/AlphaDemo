package com.chuliu.alpha.pojo;

import java.time.LocalDateTime;

/**
 * Created by chuliu on 2017/8/22.
 * Comments in a topic
 */
public class Comment {

    private long id;
    private String content;

    private User commentor;
    private LocalDateTime commentTime;

    private User lastEditUser;
    private User lastEditTime;

}
