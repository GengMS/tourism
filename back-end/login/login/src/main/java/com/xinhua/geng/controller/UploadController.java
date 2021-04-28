package com.xinhua.geng.controller;

import com.xinhua.geng.until.FastDfsUrlToHttp;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: geng
 * @Date: 2021/4/6 11:54
 */
@RestController
@CrossOrigin
public class UploadController {

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file){
        try{
            return FastDfsUrlToHttp.FastDfsUrlToHttp(file);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
    @PostMapping("/uploadImg")
    public String uploadImg(@RequestParam MultipartFile file){

        try{
            return FastDfsUrlToHttp.FastDfsUrlToHttp(file);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
