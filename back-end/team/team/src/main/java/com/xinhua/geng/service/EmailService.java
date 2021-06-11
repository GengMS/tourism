package com.xinhua.geng.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author: geng
 * @Date: 2021/5/31 11:28
 */
@FeignClient("login")
public interface EmailService {
    @GetMapping("/getMail")
    List<String> getAllMail();
}
