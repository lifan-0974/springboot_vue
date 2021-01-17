package com.lllfff.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lllfff.mapper.LeaverMapper;
import com.lllfff.model.Leaver;
import com.lllfff.model.PageResult;
import com.lllfff.service.LeaverService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//业务层
@Service
public class LeaverServiceimpl implements LeaverService {
    @Resource
    private LeaverMapper leaverMapper;
    //查询所有
    @Override
    public List<Leaver> selectall() {
        return leaverMapper.selectall();
    }

    @Override
    public com.lllfff.model.PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<com.lllfff.model.Leaver> page=   (Page<com.lllfff.model.Leaver>) leaverMapper.selectall();
        return new com.lllfff.model.PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public com.lllfff.model.PageResult findPage1(Integer pid, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        Page<com.lllfff.model.Leaver> page= (Page<com.lllfff.model.Leaver>)leaverMapper.selectByname(pid);
        return new com.lllfff.model.PageResult(page.getTotal(), page.getResult());
    }

    //根据pid查询
    @Override
    public List<Leaver> selectByname(Integer pid) {
        return leaverMapper.selectByname(pid);
    }
    //添加
    @Override
    public int insert(com.lllfff.model.Leaver leaver) {
        return leaverMapper.insert(leaver);
    }
    //修改
    @Override
    public int update(com.lllfff.model.Leaver leaver) {
        return leaverMapper.update(leaver);
    }
    //根据Id查询
    @Override
    public com.lllfff.model.Leaver selectByid(Integer lid) {
        return leaverMapper.selectByid(lid);
    }
    //审核
    @Override
    public int upstatic(com.lllfff.model.Leaver lid) {
        return leaverMapper.upstatic(lid);
    }
    //删除
    @Override
    public int delete(Integer lid) {
        return leaverMapper.delete(lid);
    }

    @Override
    public int upstatic1(Integer lid) {
        return leaverMapper.upstatic1(lid);
    }

    @Override
    public int upstatic2(Integer lid) {
        return leaverMapper.upstatic2(lid);
    }
}
