package com.ddj.controller;

import com.ddj.common.constant.ResponseEntity;
import com.ddj.service.YiZhuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Author: icho
 * @Date: 2024/10/4 13:17
 * @Describe:
 */
@Controller
@RequestMapping("yizhu")
@ResponseBody
public class YiZhuController {

    @Autowired
    private YiZhuService service;

    @RequestMapping("/insertAll")
    public ResponseEntity insertAll(@RequestParam("file") MultipartFile file, String date) {
        service.insertAll(file,date);
        return ResponseEntity.ok();
    }

    @RequestMapping("/getData")
    public ResponseEntity getData(String date,String type,String chart,String sum) {
        return ResponseEntity.ok(service.getData(date,type,chart,sum));
    }

}
