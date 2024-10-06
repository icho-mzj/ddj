package com.ddj.service;

import com.alibaba.excel.EasyExcel;
import com.ddj.entity.YiZhuEntity;
import com.ddj.common.excel.YiZhulListener;
import com.ddj.mapper.YiZhuMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author: icho
 * @Date: 2024/10/4 14:30
 * @Describe:
 */
@Slf4j
@Service
public class YiZhuService extends BaseService{

    @Autowired
    private YiZhuMapper mapper;

    public void insertAll(MultipartFile file, String date) {
        try {
            EasyExcel.read(file.getInputStream(), YiZhuEntity.class,new YiZhulListener(mapper)).
                    sheet(date).doRead();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
