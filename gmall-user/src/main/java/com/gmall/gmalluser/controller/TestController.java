package com.gmall.gmalluser.controller;

import pojo.UmsMember;
import com.gmall.gmalluser.service.impl.UmsMemberServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    UmsMemberServiceImpl UmsMemberServiceImpl;

    @RequestMapping("/")
    public List<UmsMember> get(){
        return UmsMemberServiceImpl.getlist();
    }

}
