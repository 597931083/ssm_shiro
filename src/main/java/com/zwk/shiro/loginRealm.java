package com.zwk.shiro;

import com.zwk.entity.Users;
import com.zwk.service.login.LoginService;
import com.zwk.service.permission.permissionService;
import com.zwk.vo.ActiveUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: zwk
 * @time: 2018/10/14
 * 描述
 */
@Component
public class loginRealm extends AuthorizingRealm {
    @Autowired
    private LoginService loginService;

    @Autowired
    private permissionService permissionService;
    public String getName(){
        return this.getClass().getSimpleName();
    }

    /**
     * 认证方法
     * @param token
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1、得到用户名
        String username= token.getPrincipal().toString();
        //2、根据用户名去数据库查询
        Users user=loginService.queryUserByUserName(username);
        ActiveUser activeUser=new ActiveUser();
        if(null!=user){
            //根据用户id查询角色、查询权限，这里只演示查询权限
            activeUser.setCurrentUser(user);
            activeUser.setPermissions(this.permissionService.queryPermissionByUserId(user.getId()));
            ByteSource salt=ByteSource.Util.bytes(user.getSalt());
            AuthenticationInfo info = new SimpleAuthenticationInfo(activeUser,user.getPassword(),salt,getName());
            return info;
        }else{
            //返回null表示 用户名不存在；不需要抛UnknownAccountException用户不存在异常
            return null;
        }
    }

    /**
     * 授权方法
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //得到activeUser
        ActiveUser activeUser= (ActiveUser) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //添加角色
        if(activeUser.getRoles()!=null&&activeUser.getPermissions().size()>0){
            info.addRoles(activeUser.getRoles());
        }
        //添加权限
        if(activeUser.getPermissions()!=null&&activeUser.getPermissions().size()>0){
            info.addStringPermissions(activeUser.getPermissions());
        }
        return info;
    }


}
