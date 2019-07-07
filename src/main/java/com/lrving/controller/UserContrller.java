package com.lrving.controller;

import com.lrving.common.model.JsonResult;
import com.lrving.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by goodwuxuyang on 2019/7/7.
 */
@RestController
@RequestMapping("/user")
public class UserContrller {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public Object findByUser(@PathVariable(name = "id")Integer id){
        return JsonResult.success(userService.getUserById(id));
    }
}
