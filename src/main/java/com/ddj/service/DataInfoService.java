package com.ddj.service;

import com.ddj.mapper.DataInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: icho
 * @Date: 2024/10/8 15:20
 * @Describe:
 */
@Slf4j
@Service
public class DataInfoService {

    @Autowired
    private DataInfoMapper mapper;

    public Object getData(String date, String type,String chart,String sum) {
        if (date == null || type == null) return null;
        return mapper.getInfo(date, type,chart ,sum);
    }

}
