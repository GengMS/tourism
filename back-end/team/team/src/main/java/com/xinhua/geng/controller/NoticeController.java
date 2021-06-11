package com.xinhua.geng.controller;

import com.alibaba.fastjson.JSON;
import com.xinhua.geng.entity.Notice;
import com.xinhua.geng.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * @Author: geng
 * @Date: 2021/5/31 9:54
 */
@CrossOrigin
@Controller
public class NoticeController {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    EmailService emailService;

    @PostMapping("/notice")
    @ResponseBody
    public boolean notice(@RequestBody Notice notice){
         try{
            System.out.println(notice);
            HashMap<String,Object> hashMap = new HashMap<>();

            if(notice.getAllSelect()){
                hashMap.put("addres",emailService.getAllMail());
                System.out.println(hashMap);
            }else{
                hashMap.put("addres",Arrays.asList(notice.getAddres().split(",")));
            }
            hashMap.put("theme",notice.getTheme());
            hashMap.put("content",notice.getContent());
            redisTemplate.opsForStream().add("emailStream", hashMap);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }
}
