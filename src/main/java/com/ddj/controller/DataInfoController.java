package com.ddj.controller;

import com.ddj.common.constant.ResponseEntity;
import com.ddj.service.DataInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: icho
 * @Date: 2024/10/8 15:19
 * @Describe:
 */
@Controller
@RequestMapping("data")
@ResponseBody
public class DataInfoController {

    @Autowired
    private DataInfoService service;

    @RequestMapping("/getData")
    public ResponseEntity getData(String date, String type, String chart, String sum) {
        return ResponseEntity.ok(service.getData(date,type,chart,sum));
    }
}
