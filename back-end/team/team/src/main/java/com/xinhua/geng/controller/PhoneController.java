package com.xinhua.geng.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.xinhua.geng.dao.PhoneNumDao;
import com.xinhua.geng.entity.PhoneNum;
import com.xinhua.geng.service.PhoneNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: geng
 * @Date: 2021/4/21 16:52
 */
@RestController
@CrossOrigin
public class PhoneController {

    @Autowired
    private PhoneNumService phoneNumService;

    @RequestMapping("/savePhoneNum/{phoneNum}")
    public  boolean savePhoenNum(@PathVariable Long phoneNum){
        return phoneNumService.savePhoenNum(phoneNum);
    }
    @RequestMapping("/listPhoneNum")
    public List<PhoneNum> listPhoneNum(){
        return phoneNumService.listPhoneNum();
    }

    @GetMapping("/phoneNumExcel/download")
    public void download(HttpServletResponse response) throws IOException, IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), PhoneNum.class)
                .autoCloseStream(Boolean.FALSE)
                .sheet("模板")
                .doWrite(phoneNumService.listPhoneNum());

    }
}
