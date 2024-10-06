package com.ddj.controller;

import com.ddj.common.constant.ResponseEntity;
import com.ddj.service.YiZhuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    private YiZhuService yiZhuService;

    @RequestMapping("/insertAll")
    public ResponseEntity insertAll(@RequestParam(value = "file") MultipartFile file, String date) {
        yiZhuService.insertAll(file,date);
        return ResponseEntity.ok();
    }

}
