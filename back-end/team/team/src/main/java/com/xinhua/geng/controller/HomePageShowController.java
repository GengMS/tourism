package com.xinhua.geng.controller;

import com.xinhua.geng.entity.HomePage;
import com.xinhua.geng.service.HomePageShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

/**
 * @Author: geng
 * @Date: 2021/4/27 15:12
 */
@RestController
@CrossOrigin
public class HomePageShowController {

    @Autowired
    private HomePageShowService homePageShowService;

    @RequestMapping("/updateHomePageShow")
    public boolean saveShowInfor(@RequestBody HomePage homePage){
        System.out.println(homePage);
        if(homePage.getTitle() == null || homePage.getTitle().length()<=0){
            return false;
        }

        return homePageShowService.saveShowInfor(homePage);
    }

    @RequestMapping("/listHomePageShow")
    public ArrayList<Map<Object,Object>> listShowInfor() {
        return homePageShowService.listShowInfor();
    }

    @RequestMapping("/delHomePageShow")
    public boolean delShowInfor(@RequestBody String id) {
        return homePageShowService.delShowInfor(id.replace("=",""));
    }

}
