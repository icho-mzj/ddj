package com.ddj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: icho
 * @Date: 2024/10/5 20:12
 * @Describe:
 */

@Controller
public class TemplateController {

    @RequestMapping("/test")
    public String test(Model model){
        //存入数据
        model.addAttribute("msg","Hello,Thymeleaf");
        //classpath:/templates/test.html
        return "test";
    }


}
