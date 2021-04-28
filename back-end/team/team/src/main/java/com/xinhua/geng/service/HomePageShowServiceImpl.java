package com.xinhua.geng.service;

import com.xinhua.geng.dao.InforDao;
import com.xinhua.geng.entity.HomePage;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author: geng
 * @Date: 2021/4/27 15:01
 */
@Service
public class HomePageShowServiceImpl implements HomePageShowService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
    @Autowired
    private InforDao inforDao;
    @Override
    @GlobalTransactional
    public boolean saveShowInfor(HomePage homePage) {
        try{
            if(inforDao.hasTId(homePage.gettId()) <= 0){
                return false;
            }
            String keyName = "homepage-"+UUID.randomUUID();
            redisTemplate.opsForHash().put( keyName, "id",keyName);
            redisTemplate.opsForHash().put( keyName,"title",homePage.getTitle());
            redisTemplate.opsForHash().put( keyName, "imgUrl",homePage.getImgUrl());
            redisTemplate.opsForHash().put( keyName, "tId",homePage.gettId());
            redisTemplate.opsForHash().put( keyName, "liveTime",homePage.getTime());
            redisTemplate.opsForHash().put( keyName, "saveTime",simpleDateFormat.format(new Date()));
            redisTemplate.expire(keyName,homePage.getTime(), TimeUnit.MINUTES);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<Map<Object,Object>> listShowInfor() {
        ArrayList<Map<Object,Object>> result = new ArrayList<>();
        try {
            Set<String> keys = redisTemplate.keys("homepage-*");
            for(String s : keys){
                result.add(redisTemplate.opsForHash().entries(s));
            }
            System.out.println(result);
            return result;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delShowInfor(String id) {
        try {
            boolean b = redisTemplate.delete(id);
            System.out.println(b);
            return b;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
