package com.isoftstone.pmit.project.pmit_project_test_demo_8001.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import static com.isoftstone.pmit.project.common.DateUtils.format;

@RestController
@RequestMapping("/demo")
public class TestDemoController {



    @GetMapping(value = "/getNowDate")
    public String getNowDate() {

        return "当前时间为"+format(new Date())+";返回数据模块为test_demo_8001模块，端口为8001";
    }
}
