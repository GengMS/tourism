package com.xinhua.geng.controller;

import com.xinhua.geng.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: geng
 * @Date: 2021/4/5 9:56
 */
@RestController
@CrossOrigin
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @RequestMapping("/register/{email}/{passwd}/{mailCode}")
    public boolean register(@PathVariable String email, @PathVariable String passwd, @PathVariable String mailCode){
        return registerService.register(email, passwd,mailCode);
    }
    @RequestMapping("/getMailCode/{email}")
    public boolean saveMailCode(@PathVariable String email) {
        return registerService.saveMailCode(email);
    }
    @RequestMapping("/updatePasswd/{email}/{passwd}/{mailCode}")
    public boolean updatePasswd(@PathVariable String email, @PathVariable String passwd, @PathVariable String mailCode){
        return registerService.updatePasswd(email, passwd,mailCode);
    }
}
