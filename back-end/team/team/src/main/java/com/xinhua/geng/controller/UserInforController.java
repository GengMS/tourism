package com.xinhua.geng.controller;

import com.alibaba.fastjson.JSON;
import com.xinhua.geng.entity.SelectOptions;
import com.xinhua.geng.entity.TeamInforFront;
import com.xinhua.geng.service.TeamInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: geng
 * @Date: 2021/4/19 14:52
 */
@RestController
@CrossOrigin
public class UserInforController {

    @Autowired
    private TeamInforService teamInforService;

    @RequestMapping("/uploadTeamInfor")
    public boolean saveUserInfor(@RequestBody String teamInfor){
        try {
            TeamInforFront teamInforFront = JSON.parseObject(teamInfor,TeamInforFront.class);
            System.out.println(teamInforFront);
            return teamInforService.saveTeamInfor(teamInforFront);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    };

    @RequestMapping("/delTeamInfor/{tId}")
    public boolean delUserInfor(@PathVariable int tId){
        try {
            return teamInforService.delTeamInfor(tId);
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    @RequestMapping("/listTeamInfor/{pageIndex}")
    public List<TeamInforFront> listTeamInfor(@PathVariable int pageIndex){
        List<TeamInforFront> teamInforFronts =teamInforService.listTeamInfor(pageIndex);
        System.out.println(teamInforFronts);
        return teamInforFronts;
    };
    @RequestMapping("/countTeamInfor")
    public int countTeamInfor() {
        return teamInforService.countTeamInfor();
    }

    @RequestMapping("/getTeamInfor/{tId}")
    public TeamInforFront getTeamInfor(@PathVariable int tId){
        return teamInforService.getTeamInfor(tId);
    }

    @RequestMapping("/listTeamInforByOption/{pageIndex}")
    public   List<TeamInforFront> listTeamInforByOption(@RequestBody SelectOptions selectOptions,@PathVariable  int pageIndex){
        List<TeamInforFront> teamInforFronts =  teamInforService.listTeamInforByOption(selectOptions, pageIndex);
        System.out.println(teamInforFronts);
        System.out.println(selectOptions);
        return teamInforFronts;
    }

    @RequestMapping("/countTeamInforByOptions")
    public int countTeamInforByOption(@RequestBody String selectOptions){
        SelectOptions selectOptions1 = JSON.parseObject(selectOptions,SelectOptions.class);
        System.out.println(selectOptions1);
        int result = teamInforService.countTeamInforByOption(selectOptions1);
        System.out.println(result);
        return result;
    }

}
