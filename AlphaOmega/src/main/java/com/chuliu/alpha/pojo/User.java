package com.chuliu.alpha.pojo;

import com.chuliu.alpha.pojo.relation.UserGroupItem;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by chuliu on 2017/8/22.
 * pojo User
 */
@Component()
@Scope("prototype")
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public long getCoin() {
        return coin;
    }

    public void setCoin(long coin) {
        this.coin = coin;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<UserGroupItem> getUserGroupItemList() {
        return userGroupItemList;
    }

    public void setUserGroupItemList(List<UserGroupItem> userGroupItemList) {
        this.userGroupItemList = userGroupItemList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", displayName='" + displayName + '\'' +
                ", password='" + password + '\'' +
                ", registerTime=" + registerTime +
                ", lastLoginTime=" + lastLoginTime +
                ", coin=" + coin +
                ", active=" + active +
                ", userGroupItemList=" + userGroupItemList +
                '}';
    }
}
