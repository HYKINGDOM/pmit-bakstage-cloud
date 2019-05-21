package com.isoftstone.pmit.project.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fegin")
public class FeginController {

    @Autowired
    private FeginService feginService;

    @GetMapping("/getNowDate")
    public String getNowDate() {
        return "fegin"+feginService.getNowDate();
    }

}
