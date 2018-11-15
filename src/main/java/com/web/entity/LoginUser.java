package com.web.entity;

import java.io.Serializable;

/**
 * @author crystalzhao
 * @version V1.0
 * @date 2018/11/2
 */
public class LoginUser implements Serializable {
    private User user;
    private SysRole role;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SysRole getRole() {
        return role;
    }

    public void setRole(SysRole role) {
        this.role = role;
    }
}
