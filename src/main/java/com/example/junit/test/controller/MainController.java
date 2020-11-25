package com.example.junit.test.controller;

import com.example.junit.test.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/test")
    public boolean check(@RequestParam(value = "str") String str){
        return mainService.checkString(str);
    }

}
