package com.lllfff.mapper;

import com.lllfff.model.Leaver;

import java.util.List;

public interface LeaverMapper {
    List<Leaver> selectall();
    List<Leaver>  selectByname(Integer pid);
    com.lllfff.model.Leaver selectByid(Integer lid);
    int insert(com.lllfff.model.Leaver leaver);
    int update(com.lllfff.model.Leaver leaver);
    int upstatic(com.lllfff.model.Leaver leaver);
    int delete(Integer lid);
    int upstatic1(Integer lid);
    int upstatic2(Integer lid);
}
