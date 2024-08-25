package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.user;
@RestController
public class hellowCo {

    @GetMapping("/hellow/*")
    public String hello(){
        return "Hello World";
    }

    @RequestMapping(value = "/getTest",method = RequestMethod.GET)
    public String getTest(String name,String phone){
        System.out.println(name);
        System.out.println(phone);
        return "GET请求";
    }

    @RequestMapping(value = "/postTest2",method = RequestMethod.POST)
    public String postTest2(user user){
        System.out.println(user);
        return "POST请求";
    }

    @RequestMapping(value = "/postTest3",method = RequestMethod.POST)
    public String postTest3(@RequestBody user user){
        System.out.println(user);
        return "POST请求";
    }
}

