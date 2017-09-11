package com.chuliu.alpha.pojo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by chuliu on 2017/8/22.
 */
public class Issue {

    //基本信息
    private long id;
    private User creator;
    private String summary;
    private String description;
    private LocalDateTime createTime;
    private LocalDateTime closeTime;

    //评论列表
    private long commentsCount;
    private List<Comment> comments;


}
