package com.lllfff.config;

import com.lllfff.realm.AccountRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

//配置类
@Configuration
public class AccountConfig {



    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){

     ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
    //setdefaultWebSecurityManager
    shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //设置三个页面的权限  authc登录，perms权限， roles角色
        Map<String,String> map=new HashMap<>();
        map.put("/*","authc");
        //设置
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        //设置登录界面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //设置权限不足界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");
        return shiroFilterFactoryBean;
    }
   @Bean
   public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("accountRealm") AccountRealm accountRealm){
        //获取defaultWebSecurityManager
       DefaultWebSecurityManager Manager=new DefaultWebSecurityManager();
       //setrealm
       Manager.setRealm(accountRealm);
       return Manager;
   }
    @Bean
    public AccountRealm accountRealm(){
        //获取realm
        return new AccountRealm();
    }


}
