package com.ddj.service;

import com.alibaba.excel.EasyExcel;
import com.ddj.common.DateUtils;
import com.ddj.common.excel.DaBaoAndTuiYaoListener;
import com.ddj.mapper.DaBaoAndTuiYaoMapper;
import com.ddj.mapper.DataInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author: icho
 * @Date: 2024/10/5 13:16
 * @Describe:
 */
@Slf4j
@Service
public class DaBaoAndTuiYaoService {

    @Autowired
    private DaBaoAndTuiYaoMapper daBaoAndTuiYaoMapper;

    @Autowired
    private DataInfoMapper dataInfoMapper;

    private String TYPE = "yizhu";


    public void insertAll(MultipartFile file, String date) {
        if (file==null || date==null) return;
        String name = file.getOriginalFilename();
        if (name.contains("打包药")) TYPE = "dabaoyao";
        if (name.contains("退药")) TYPE = "tuiyao";
        if (date.charAt(0) == '0') date = date.replace("0", "") + "月";
        try {
            daBaoAndTuiYaoMapper.deleteSource(DateUtils.fixYear(date), TYPE);
            dataInfoMapper.deleteInfo(DateUtils.fixYear(date), TYPE);
            EasyExcel.read(file.getInputStream(), new DaBaoAndTuiYaoListener(daBaoAndTuiYaoMapper,this,dataInfoMapper)).
                    sheet(date).doRead();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getType() {
        return TYPE;
    }
}
