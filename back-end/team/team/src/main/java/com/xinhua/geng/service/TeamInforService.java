package com.xinhua.geng.service;

import com.xinhua.geng.entity.SelectOptions;
import com.xinhua.geng.entity.TeamInforFront;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: geng
 * @Date: 2021/4/19 14:48
 */
public interface TeamInforService {
    boolean saveTeamInfor(TeamInforFront teamInforFront);

    boolean delTeamInfor(int tId);

    List<TeamInforFront> listTeamInfor(int pageIndex);
    int countTeamInfor();
    TeamInforFront getTeamInfor(int tId);
    List<TeamInforFront> listTeamInforByOption(@Param("selectOptions") SelectOptions selectOptions, @Param("pageIndex") int pageIndex);
    int countTeamInforByOption( SelectOptions selectOptions);
}
