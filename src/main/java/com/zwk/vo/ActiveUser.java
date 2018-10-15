package com.zwk.vo;

import com.zwk.entity.Users;

import java.util.List;

/**
 * @author: zwk
 * @time: 2018/10/15
 * 描述
 */
public class ActiveUser {
    //当前用户
    private Users currentUser;
    //当前用户的角色
    private List<String> roles;
    //当前用户的权限
    private List<String> permissions;

    public Users getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Users currentUser) {
        this.currentUser = currentUser;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
