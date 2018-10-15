package com.zwk.service.login;

import com.zwk.dao.UsersMapper;
import com.zwk.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zwk
 * @time: 2018/10/14
 * 描述
 */
@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public Users queryUserByUserName(String username) {
        return usersMapper.queryUserByUserName(username);
    }
}
