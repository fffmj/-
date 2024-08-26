package com.example.uesr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.uesr.entity.UserEntity;
import com.example.uesr.mapper.UserMapper;
import com.example.uesr.req.UserRep;
import com.example.uesr.req.UserSaveReq;
import com.example.uesr.resp.PageResp;
import com.example.uesr.service.UserService;
import com.example.uesr.utils.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.example.uesr.utils.SnowFlake;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private SnowFlake snowFlake;

    @Override
    public PageResp<UserEntity> getList(UserRep userRep) {

        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(userRep.getName())){
            queryWrapper.lambda().eq(UserEntity::getName,userRep.getName());
        }

        if (!ObjectUtils.isEmpty(userRep.getPhone())){
            queryWrapper.lambda().eq(UserEntity::getPhone,userRep.getPhone());
        }

        if (!ObjectUtils.isEmpty(userRep.getCity())){
            queryWrapper.lambda().eq(UserEntity::getCity,userRep.getCity());
        }

        Page<UserEntity> page = new Page<>(userRep.getPage(), userRep.getSize());
        IPage<UserEntity> userEntityIPage = userMapper.selectPage(page, queryWrapper);
        PageResp<UserEntity> pageResp = new PageResp<>();
        pageResp.setTotal(userEntityIPage.getTotal());
        pageResp.setList(userEntityIPage.getRecords());
        return pageResp;
    }

    @Override
    public void delete(Long id) {
        userMapper.deleteById(id);
    }

    @Override
    public void save(UserSaveReq req1) {
        UserEntity entity = CopyUtil.copy(req1, UserEntity.class);
        if (ObjectUtils.isEmpty(req1.getId())){
            entity.setId(snowFlake.nextId());
            userMapper.insert(entity);
        }else{
            userMapper.updateById(entity);
        }
    }

//    @Override
//    public void save(UserSaveReq req) {
//        UserEntity entity = CopyUtil.copy(req, UserEntity.class);
//        if (ObjectUtils.isEmpty(req.getId())){
//            entity.setId(snowFlake.nextId());
//            userMapper.insert(entity);
//        }else{
//            userMapper.updateById(entity);
//        }
//    }


}
