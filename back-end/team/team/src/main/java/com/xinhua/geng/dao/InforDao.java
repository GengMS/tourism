package com.xinhua.geng.dao;

import com.xinhua.geng.entity.SelectOptions;
import com.xinhua.geng.entity.TeamInfor;
import com.xinhua.geng.entity.TeamInforFront;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: geng
 * @Date: 2021/4/19 11:24
 */
@Mapper
@Component
public interface InforDao {
    boolean saveInfor(TeamInforFront teamInforFront);
    boolean delInfor(int tId);
    List<TeamInforFront> listTeamInfor(int pageIndex);
    int countTeamInfor();
    TeamInforFront getTeamInfor(int tId);
    List<TeamInforFront> listTeamInforByOption(@Param("selectOptions") SelectOptions selectOptions,  @Param("pageIndex") int pageIndex);
    int countTeamInforByOption(@Param("selectOptions") SelectOptions selectOptions);
    int hasTId(int tId);
}
