package com.xinhua.geng;

import com.alibaba.fastjson.JSON;
import com.xinhua.geng.dao.InforDao;
import com.xinhua.geng.entity.SelectOptions;
import com.xinhua.geng.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class TeamApplicationTests {

    @Autowired
    private InforDao inforDao;
    @Autowired
    private RedisTemplate<String,Object> template;
    @Test
    void contextLoads() throws InterruptedException {
        System.out.println(inforDao.hasTId(84));
    }


}
