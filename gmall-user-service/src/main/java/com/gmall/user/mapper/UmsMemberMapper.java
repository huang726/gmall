package com.gmall.user.mapper;

import pojo.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface UmsMemberMapper extends Mapper<UmsMember> {
    public List<UmsMember> getlist();

}