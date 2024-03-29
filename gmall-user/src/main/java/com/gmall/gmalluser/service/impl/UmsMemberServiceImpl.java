package com.gmall.gmalluser.service.impl;

import com.gmall.gmalluser.mapper.UmsMemberMapper;
import org.springframework.stereotype.Service;
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
