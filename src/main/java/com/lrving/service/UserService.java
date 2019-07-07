package com.lrving.service;

import com.lrving.entity.User;

/**
 * Created by goodwuxuyang on 2019/7/7.
 */
public interface UserService {
    User getUserById(Integer id);

    int addUser(User user);
}
