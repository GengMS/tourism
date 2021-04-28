package com.xinhua.geng.controller;

import com.xinhua.geng.entity.User;
import com.xinhua.geng.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: geng
 * @Date: 2021/4/5 9:41
 */
@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @RequestMapping("/login/{email}/{mailCode}")
    public User Login(@PathVariable String email, @PathVariable String mailCode){
        return loginService.getUser(email,mailCode);
    }
}
