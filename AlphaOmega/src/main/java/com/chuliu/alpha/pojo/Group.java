package com.chuliu.alpha.pojo;

import com.chuliu.alpha.pojo.relation.UserGroupItem;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by chuliu on 2017/8/22.
 * Group pojo
 */
public class Group {

    private long id;
    private String groupName;

    private LocalDateTime createTime;

    private List<UserGroupItem> userGroupItemList;
}
