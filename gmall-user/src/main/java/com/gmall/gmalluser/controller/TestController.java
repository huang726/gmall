package com.gmall.gmalluser.controller;

import com.gmall.gmalluser.service.impl.UmsMemberServiceImpl;
import pojo.UmsMember;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UmsMemberService;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    UmsMemberService UmsMemberService;

    @RequestMapping("/")
    public List<UmsMember> get(){
        return UmsMemberService.getlist();
    }

}
