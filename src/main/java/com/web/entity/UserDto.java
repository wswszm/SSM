package com.web.entity;

/**
 * @author crystalzhao
 * @version V1.0
 * @date 2018/11/14
 */
public class UserDto extends User {
    private String roleType;

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}
