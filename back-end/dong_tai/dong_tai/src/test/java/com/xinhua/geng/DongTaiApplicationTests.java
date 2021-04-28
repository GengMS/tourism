package com.xinhua.geng;

import com.xinhua.geng.dao.CommentDao;
import com.xinhua.geng.dao.ContentDao;
import com.xinhua.geng.dao.DongDao;
import com.xinhua.geng.dao.DotDao;
import com.xinhua.geng.entity.Dong;
import com.xinhua.geng.entity.DongContent;
import com.xinhua.geng.entity.DongFront;
import com.xinhua.geng.service.DongTaiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@SpringBootTest
class DongTaiApplicationTests {

    @Autowired
    private DongDao dongDao;
    @Autowired
    private DongTaiService dongTaiService;
    @Autowired
    private CommentDao com;
    @Autowired
    private ContentDao contentDao;
    @Autowired
    private DotDao dotDao;
    @Test
    void contextLoads() {
        System.out.println(dongDao.countDong());
    }

    @Test
    void test(){
        System.out.println(dongTaiService.increDot(96,1));
    }

}
