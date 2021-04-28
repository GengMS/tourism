package com.xinhua.geng.service;

import com.xinhua.geng.entity.UserInfor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: geng
 * @Date: 2021/4/11 17:39
 */
@FeignClient("login")
public interface UserInforService {

    @PostMapping("/hadInfor/{id}")
    public int hadInfor(@PathVariable("id") int id);

    @PostMapping("/getUserInfor/{id}")
    public UserInfor getUserInfor(@PathVariable("id") int id);

    @PostMapping("/getMail/{id}")
    public String getMail(@PathVariable("id") int id);
}
