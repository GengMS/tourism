package com.xinhua.geng.service;

import com.xinhua.geng.dao.PhoneNumDao;
import com.xinhua.geng.entity.PhoneNum;
import com.xinhua.geng.entity.TeamInforFront;
import com.xinhua.geng.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author: geng
 * @Date: 2021/4/21 16:50
 */
@Service
public class PhoneNumServiceImpl implements PhoneNumService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    private RedisUtil redisUtil = new RedisUtil(redisTemplate);

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public boolean savePhoenNum(Long phoneNum) {
        try{
            if(redisTemplate.hasKey("num"+phoneNum)){
                return true;
            }

            String keyName = "num"+phoneNum;
            System.out.println(keyName);
            redisTemplate.opsForHash().put(keyName,"phoneNum",phoneNum);
            redisTemplate.opsForHash().put(keyName,"date",simpleDateFormat.format(new Date()));
            redisTemplate.expire(keyName,30, TimeUnit.DAYS);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<PhoneNum> listPhoneNum() {
        Set<String> keys = redisTemplate.keys("num*");
        List<PhoneNum> maps = new ArrayList<>();
        for(String s : keys) {
            maps.add(new PhoneNum((Long) redisTemplate.opsForHash().get(s,"phoneNum"),(String) redisTemplate.opsForHash().get(s,"date")));
        }
        return maps;
    }


}
