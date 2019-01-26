package com.sym.mybatisplus.service.system.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sym.mybatisplus.mapper.system.UserMapper;
import com.sym.mybatisplus.model.system.User;
import com.sym.mybatisplus.service.system.IUserService;
import com.sym.redis.annotation.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @RedisCache(type = User.class)
    public List<User> userList() {
        return userMapper.userList();
    }
}