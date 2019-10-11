package com.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.UmsMember;
import service.UmsMemberService;

import java.util.List;

@RestController
public class TestController {

    @Reference
    UmsMemberService UmsMemberService;

    @RequestMapping("/")
    public List<UmsMember> get(){
        return UmsMemberService.getlist();
    }

}
