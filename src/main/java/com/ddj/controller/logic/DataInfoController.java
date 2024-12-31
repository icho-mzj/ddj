package com.ddj.controller.logic;

import com.ddj.common.constant.ResponseResult;
import com.ddj.service.logic.DataInfoService;
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
    public ResponseResult getData(String date, String type, String chart, String sum) {
        ResponseResult result = ResponseResult.success();
        result.put("data", service.getData(date,type,chart,sum));
        return result;
    }
}
