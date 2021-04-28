package com.xinhua.geng.controller;

import com.alibaba.fastjson.JSONObject;
import com.xinhua.geng.entity.UserInfor;
import com.xinhua.geng.service.UserInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: geng
 * @Date: 2021/4/6 15:27
 */
@RestController
@CrossOrigin
public class UserInforController {

    @Autowired
    UserInforService userInforService;

    @PostMapping("/updateUserInfor/{userInfor}")
    public boolean updateUserInfor(@PathVariable String userInfor) {

        UserInfor userInfor1 = JSONObject.parseObject(userInfor, UserInfor.class);
        return userInforService.updateUserInfor(userInfor1);
    }

    @PostMapping("/getUserInfor/{id}")
    public  UserInfor getInfor(@PathVariable int id) {
        return userInforService.getInfor(id);
    }

    @PostMapping("/hadInfor/{id}")
    public Integer hadInfor(@PathVariable int id) {
        return userInforService.hadInfor(id);
    }
    @PostMapping("/getMail/{id}")
    public String getMail(@PathVariable int id){
        return userInforService.getMail(id);
    };
}
