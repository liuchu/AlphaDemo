package com.chuliu.alpha.pojo;

import java.time.LocalDateTime;

/**
 * Created by chuliu on 2017/8/22.
 */
public class Issue {

    private long id;
    private User creator;
    private String summary;
    private String description;
    private LocalDateTime createTime;
    private LocalDateTime closeTime;


}
