package com.example.uesr.service;

import com.example.uesr.entity.UserEntity;
import com.example.uesr.req.UserRep;
import com.example.uesr.req.UserSaveReq;

import com.example.uesr.resp.PageResp;

public interface UserService {




    PageResp<UserEntity> getList(UserRep userRep);

    void delete(Long id);

    void save(UserSaveReq req1);
}
