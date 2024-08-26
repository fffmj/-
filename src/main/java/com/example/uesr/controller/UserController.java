package com.example.uesr.controller;

import com.example.uesr.req.UserRep;
import com.example.uesr.req.UserSaveReq;
import com.example.uesr.resp.CommonResp;
import com.example.uesr.resp.PageResp;

import com.example.uesr.service.UserService;
import org.springframework.web.bind.annotation.*;

import com.example.uesr.entity.UserEntity;


import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;



    @GetMapping("/getList")
    public CommonResp getList(UserRep userRep){
        CommonResp<PageResp<UserEntity>> resp = new CommonResp<>();
        PageResp<UserEntity> List = userService.getList(userRep);
        resp.setContent(List);
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id){
        CommonResp<UserEntity> resp = new CommonResp<>();
        userService.delete(id);
        return resp;
    }



    @PostMapping("/save")
    public CommonResp save(@RequestBody UserSaveReq req1){
        CommonResp<UserEntity> resp = new CommonResp<>();
        userService.save(req1);
        return resp;

    }
}