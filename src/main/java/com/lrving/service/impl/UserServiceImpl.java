package com.lrving.service.impl;

import com.lrving.annotation.Master;
import com.lrving.entity.User;
import com.lrving.mapper.UserMapper;
import com.lrving.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by goodwuxuyang on 2019/7/7.
 */

@Service
//@Transactional(readOnly = true) // 这里加了会先初始化DataSource,Aop实现的主从数据源选择设置的key无法被读取
public class UserServiceImpl implements UserService{


    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {

        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int addUser(User user) {
        int insert = userMapper.insert(user);
        return insert;
    }


}
