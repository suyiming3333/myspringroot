package com.sym.mybatisplus.service.system.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sym.mybatisplus.mapper.system.UserMapper;
import com.sym.mybatisplus.model.system.User;
import com.sym.mybatisplus.service.system.IUserService;
import org.springframework.stereotype.Service;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


}