package com.zwk.controller;


import com.zwk.entity.Users;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: zwk
 * @time: 2018/10/14
 * 描述
 */
@Controller
@RequestMapping("login")
public class LoginController {
    /*
     *跳转到登录页面
     */
    @RequestMapping(value="toLogin")
    public String toLogin(){
        System.out.println("toLogin");
        return "login";
    }

    /**
     * 登录
     */
    @RequestMapping(value="login",method = RequestMethod.POST)
    public Object login(Users user, Model model){
        //1、创建UsernamePasswordToken
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        //2、得到subject
        Subject subject= SecurityUtils.getSubject();
        //3、进行认证
        try {
            subject.login(token);
            System.out.println("认证成功！");
            model.addAttribute("msg","认证成功");
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码不正确");
            model.addAttribute("msg", "密码不正确");
        } catch (UnknownAccountException e){
            System.out.println("用户不存在");
            model.addAttribute("msg", "用户不存在");
        }

        return model;
    }

}
