package com.ddj.service.logic;

import com.ddj.entity.logic.DataInfo;
import com.ddj.mapper.logic.DataInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        List<DataInfo> list = mapper.getInfo(date, type, chart, sum);
        list.forEach(i -> i.setRate(i.getRate()+"%"));
        return list;
    }

}
