package com.ddj.controller;

import com.ddj.common.constant.ResponseEntity;
import com.ddj.service.DaBaoAndTuiYaoService;
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
    public ResponseEntity insertAll(@RequestParam("file") MultipartFile file, String date) {
        service.insertAll(file,date);
        return ResponseEntity.ok();
    }

}
