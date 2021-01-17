package com.lllfff.model;

import lombok.Data;

@Data
//用户表
public class People {
    //用户id
     Integer  pid ;
     //用户登录名
    String  username;
    //用户密码
    String  password ;
    //用户等级0主管1员工
    Integer  pstatic ;
    //工作人员姓名
    String lname;
}
