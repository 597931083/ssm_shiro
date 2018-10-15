package com.zwk.service.login;

import com.zwk.entity.Users;

/**
 * @author: zwk
 * @time: 2018/10/14
 * 描述
 */
public interface LoginService {
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    public Users queryUserByUserName(String username);
}
