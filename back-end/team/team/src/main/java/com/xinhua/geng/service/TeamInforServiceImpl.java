package com.xinhua.geng.service;

import com.xinhua.geng.dao.InforDao;
import com.xinhua.geng.dao.InforImgDao;
import com.xinhua.geng.dao.PathDao;
import com.xinhua.geng.entity.SelectOptions;
import com.xinhua.geng.entity.TeamInforFront;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: geng
 * @Date: 2021/4/19 14:49
 */
@Service
public class TeamInforServiceImpl implements TeamInforService {

    @Autowired
    private InforDao inforDao;
    @Autowired
    private PathDao pathDao;
    @Autowired
    private InforImgDao inforImgDao;

    @Override
    @GlobalTransactional
    public boolean saveTeamInfor(TeamInforFront teamInforFront) {
        TeamInforFront teamInforFront1 = teamInforFront;
        inforDao.saveInfor(teamInforFront1);
        int tId = teamInforFront1.gettId();
        ArrayList<String> paths = teamInforFront1.getBuZhou();
        for(String s : paths) {
            pathDao.savePath(tId,s);
        }
        ArrayList<String> imgList = teamInforFront1.getFileList();
        for(String s : imgList){
            inforImgDao.saveInforImg(tId,s);
        }
        return true;
    }

    @Override
    @GlobalTransactional
    public boolean delTeamInfor(int tId) {
        pathDao.delPath(tId);
        inforImgDao.delInforImg(tId);
        inforDao.delInfor(tId);
        return true;
    }

    @Override
    public List<TeamInforFront> listTeamInfor(int pageIndex) {
        return inforDao.listTeamInfor(pageIndex*10-10);
    }

    @Override
    public int countTeamInfor() {
        return inforDao.countTeamInfor();
    }

    @Override
    public TeamInforFront getTeamInfor(int tId) {
        return inforDao.getTeamInfor(tId);
    }

    @Override
    public List<TeamInforFront> listTeamInforByOption(SelectOptions selectOptions, int pageIndex) {
        return inforDao.listTeamInforByOption(selectOptions, pageIndex*10-10);
    }

    @Override
    public int countTeamInforByOption(SelectOptions selectOptions) {
        return inforDao.countTeamInforByOption(selectOptions);
    }
}
