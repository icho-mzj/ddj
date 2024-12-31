package com.ddj.controller.logic;

import com.ddj.common.constant.ResponseResult;
import com.ddj.service.logic.YiZhuService;
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
    public ResponseResult insertAll(@RequestParam("file") MultipartFile file, String date) {
        ResponseResult result = ResponseResult.success();
        service.insertAll(file,date);
        return result;
    }

    @RequestMapping("/getData")
    public ResponseResult getData(String date,String type,String chart,String sum) {
        ResponseResult result = ResponseResult.success();
        service.getData(date,type,chart,sum);
        return result;
    }

}
