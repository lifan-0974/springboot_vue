package com.lllfff.realm;

import com.lllfff.model.People;
import com.lllfff.service.PeopleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountRealm extends AuthorizingRealm {
    @Autowired
    private PeopleService peopleService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取token中的登录信息
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        //根据service Byname方法
        com.lllfff.model.People people=peopleService.findbyname(token.getUsername());
        if (people!=null){
            //登录名正确 进行密码判断
            return  new SimpleAuthenticationInfo(people,people.getPassword(),getName());
            //密码错误登录失败报错IncorrectCredentialsException
        }
        //登录名不正确报错UnknownAccountException
        return null;
    }
}
