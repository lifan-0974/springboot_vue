package com.lllfff.service;

import com.lllfff.model.Leaver;
import com.lllfff.model.PageResult;

import java.util.List;

public interface LeaverService {
    List<Leaver> selectall();

    public PageResult findPage(int pageNum, int pageSize);

    public PageResult findPage1(Integer pid,int pageNum, int pageSize);
    List<Leaver>  selectByname(Integer pid);
    int insert(Leaver leaver);
    int update(Leaver leaver);
    Leaver selectByid(Integer lid);
    int upstatic(Leaver leaver);
    int delete(Integer lid);

    int upstatic1(Integer lid);
    int upstatic2(Integer lid);
}
