package com.ddj.controller.logic;

import com.ddj.common.constant.ResponseResult;
import com.ddj.service.logic.DaBaoAndTuiYaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: icho
 * @Date: 2024/10/5 13:14
 * @Describe:
 */
@Controller
@RequestMapping("dabaoyaoandtuiyao")
@ResponseBody
public class DaBaoAndTuiYaoController {

    @Autowired
    private DaBaoAndTuiYaoService service;

    @RequestMapping("/insertAll")
    public ResponseResult insertAll(@RequestParam("file") MultipartFile file, String date) {
        ResponseResult result = ResponseResult.success();
        service.insertAll(file,date);
        return result;
    }

}
