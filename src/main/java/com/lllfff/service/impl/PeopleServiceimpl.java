package com.lllfff.service.impl;

import com.lllfff.mapper.PeopleMapper;
import com.lllfff.model.People;
import com.lllfff.service.PeopleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//业务层
@Service
public class PeopleServiceimpl implements PeopleService {
    @Resource
    private PeopleMapper peopleMapper;

    //登录
    @Override
    public com.lllfff.model.People findbyname(String username) {
        return peopleMapper.findbyname(username);

    }

}
