package com.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gmall.user.mapper.UmsMemberMapper;
import pojo.UmsMember;
import service.UmsMemberService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Resource
    UmsMemberMapper umsMemberMapper;

    @Override
    public List<UmsMember> getlist() {

        return umsMemberMapper.select(null);
    }
}
