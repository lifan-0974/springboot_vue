package com.lllfff.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
//请假信息表
public class Leaver {
    //id
    Integer  lid;
    //请假类型
    String ltitle ;
    //请假时间
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    Date lnewtime;
    //收假时间
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    Date  loidtime;
    //原因
    String  cause;
    //部门
    String  branch;
    //审批人
    String  approver;
    //请假时间
    String   ltime;
    //审批时间
    String  approvertime ;
    //请假状态1审核中0已归档
    Integer   lstatic ;
    //是否同意1同意0不同意
    Integer  unify;
    //people表外键id
    Integer  pid;
    com.lllfff.model.People people;
}
