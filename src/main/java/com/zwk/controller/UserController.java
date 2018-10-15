package com.zwk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: zwk
 * @time: 2018/10/15
 * 描述
 */
@Controller
public class UserController {
    @RequestMapping("/loadAllUsers")
    public String loadUsers(){
        System.out.println("获取用户列表");
        return null;
    }


}
