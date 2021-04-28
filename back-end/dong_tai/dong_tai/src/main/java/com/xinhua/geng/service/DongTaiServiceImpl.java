package com.xinhua.geng.service;

import com.xinhua.geng.dao.CommentDao;
import com.xinhua.geng.dao.ContentDao;
import com.xinhua.geng.dao.DongDao;
import com.xinhua.geng.dao.DotDao;
import com.xinhua.geng.entity.Comment;
import com.xinhua.geng.entity.Dong;
import com.xinhua.geng.entity.DongFront;
import com.xinhua.geng.entity.UserInfor;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.catalina.User;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Author: geng
 * @Date: 2021/4/9 17:19
 */
@Service
public class DongTaiServiceImpl implements DongTaiService {

    @Autowired
    private ContentDao contentDao;
    @Autowired
    private DongDao dongDao;
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private UserInforService userInforService;

    @Autowired
    private DotDao dotDao;
    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public boolean delDong(int dId) {
            dotDao.delDotbyDid(dId);
            commentDao.delComment(dId);
            contentDao.delDong(dId);
            return dongDao.delDong(dId);
    }

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public boolean saveDong(DongFront dongFront) {
        System.out.println("------------");
        System.out.println(dongFront);
        System.out.println("-----------");
            HashMap<String, Object> map = new HashMap<>(5);
            map.put("dId",1);
            map.put("uId",dongFront.getuId());
            map.put("type",dongFront.getType());
            map.put("sight",dongFront.getSight());
            dongDao.saveDong(map);
            Integer dId = (Integer) map.get("dId");
            contentDao.saveDong(dId,"标题",dongFront.getTitle());
            List<String> imgList = dongFront.getImgList();
            if( imgList.size() <= 0) {
                return true;
            }
            for(String string : imgList) {
                contentDao.saveDong(dId,"图片", string);
            }
            return true;

    }

    @Override
    public List<Dong> listDong(int senderUId, int pageIndex) {

        List<Dong> dongs = dongDao.listDong(pageIndex*10-10,10);
        System.out.println("---------------");
        System.out.println(dongs.size());
        System.out.println("------------");
        for( int i = 0; i < dongs.size(); i++ ){

            int uId =dongs.get(i).getuId();
            Dong dong = dongs.get(i);
            if(dotDao.getDot(dong.getdId(),senderUId) >= 1) {
                dong.setGoDot(true);
            }else{
                dong.setGoDot(false);
            }
            int hadInfor = userInforService.hadInfor(uId);
            if( hadInfor == 0 ) {
                dong.setUserName(userInforService.getMail(uId));
                dongs.set(i,dong);
            }else if( hadInfor == 1){
                UserInfor userInfor = userInforService.getUserInfor(uId);
                dong.setImgUrl( userInfor.getImgUrl() );
                dong.setUserName(userInfor.getName());
                dongs.set(i,dong);
            }
        }
        for(Dong dong : dongs) {
            System.out.println(dong);
        }
        return dongs;
    }

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public boolean saveComment(int dId, int uId, String comment) {
        commentDao.saveComment(dId, uId, comment);
        return dongDao.increComments(dId);
    }


    @Override
    @GlobalTransactional
    public boolean increDot(int dId,int uId) {
        dotDao.saveDot(dId, uId);
        return dongDao.increDot(dId);
    }

    @Override
    @GlobalTransactional
    public boolean decDot(int dId, int uId) {
        dotDao.delDot(dId, uId);
        return dongDao.decDot(dId);
    }

    @Override
    public List<Comment> listComments(int dId) {
        try{
            List<Comment> comments = commentDao.listComments(dId);
            for(Comment comment : comments) {
                int uId = comment.getuId();
                int hadInfor = userInforService.hadInfor(uId);
                System.out.println(hadInfor);
                if (hadInfor == 0) {
                    comment.setName(userInforService.getMail(uId));

                }else if(hadInfor == 1){
                    UserInfor userInfor = userInforService.getUserInfor(uId);
                    comment.setImgUrl( userInfor.getImgUrl() );
                    comment.setName(userInfor.getName());

                }
            }
            return comments;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Comment>();
        }

    }

    @Override
    public List<String> getSight() {
        return dongDao.getSight();
    }

    @Override
    public Integer countDong() {
        return dongDao.countDong();
    }

    @Override
    public Integer countDongBySight(String sight) {
        return dongDao.countDongBySight(sight);
    }

    @Override
    public List<Dong> listDongBySight(int senderUId, String sight, int pageIndex ) {
        List<Dong> dongs = dongDao.listDongBySight(sight,pageIndex*10-10,10);
        for( int i = 0; i < dongs.size(); i++ ){
            int uId =dongs.get(i).getuId();
            Dong dong = dongs.get(i);
            if(dotDao.getDot(dong.getdId(),senderUId) >= 1) {
                dong.setGoDot(true);
            }else{
                dong.setGoDot(false);
            }
            int hadInfor = userInforService.hadInfor(uId);
            if( hadInfor == 0 ) {
                dong.setUserName(userInforService.getMail(uId));
                dongs.set(i,dong);
            }else if( hadInfor == 1){
                UserInfor userInfor = userInforService.getUserInfor(uId);
                dong.setImgUrl( userInfor.getImgUrl() );
                dong.setUserName(userInfor.getName());
                dongs.set(i,dong);
            }
        }
        for(Dong dong : dongs) {
            System.out.println(dong);
        }
        return dongs;
    }

    @Override
    public Dong getDong(int dId) {
        Dong dong = dongDao.getDong(dId);
        UserInfor userInfor = userInforService.getUserInfor(dong.getuId());
        dong.setUserName(userInfor.getName());
        dong.setImgUrl(userInfor.getImgUrl());
        return dong;
    }


}
