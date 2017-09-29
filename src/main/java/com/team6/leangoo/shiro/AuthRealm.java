package com.team6.leangoo.shiro;

import com.team6.leangoo.mapper.UserMapper;
import com.team6.leangoo.model.Permission;
import com.team6.leangoo.model.Role;
import com.team6.leangoo.model.User;
import com.team6.leangoo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AgZou on 2017/8/24.
 */
public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    //权限控制
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        System.out.println("权限配置-->AuthRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        User user= (User) principal.getPrimaryPrincipal();//获取之前保存的user信息
        for(Role r:user.getRoles()){
            authorizationInfo.addRole(r.getRoleName());//添加角色
            for(Permission p:r.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermissionName());//添加权限
            }
        }
        return authorizationInfo;
    }

    @Override
    //登录验证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("登录验证运行");
        String username= (String) token.getPrincipal();//获得用户输入账号
        System.out.println("username="+username);
        User user=userService.findUserByAccount(username);//从数据库读取用户资料
        if(user==null) {
            return null;
        }
        System.out.println(user.toString());
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(user,user.getUserPassword(),getName());
        return authenticationInfo;//返回一个AuthenticationInfo对象,里面保存了user信息
    }
}
