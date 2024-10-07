package com.ddj.service;

import com.alibaba.excel.EasyExcel;
import com.ddj.common.DateUtils;
import com.ddj.common.constant.ResponseEntity;
import com.ddj.common.excel.DaBaoAndTuiYaoListener;
import com.ddj.entity.DaBaoAndTuiYaoInfo;
import com.ddj.entity.DaBaoAndTuiYaoSource;
import com.ddj.mapper.DaBaoAndTuiYaoMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hpsf.Decimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: icho
 * @Date: 2024/10/5 13:16
 * @Describe:
 */
@Slf4j
@Service
public class DaBaoAndTuiYaoService {

    @Autowired
    private DaBaoAndTuiYaoMapper mapper;

    private String TYPE = "yizhu";


    public void insertAll(MultipartFile file, String date) {
        String name = file.getOriginalFilename();
        if (name.contains("打包药")) TYPE = "dabaoyao";
        if (name.contains("退药")) TYPE = "tuiyao";
        try {
            mapper.deleteByYearAndMonth(DateUtils.fixYear(date), TYPE);
            EasyExcel.read(file.getInputStream(), new DaBaoAndTuiYaoListener(mapper,this)).
                    sheet(date).doRead();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getType() {
        return TYPE;
    }

    public Object getData(String date, String type) {
        List<DaBaoAndTuiYaoInfo> list = mapper.getInfo(date, type);
        System.out.println("list = " + list);
        List<String> keshiList = new ArrayList<>();
        List<Integer> valueList = new ArrayList<>();
        List<Double> rateList = new ArrayList<>();
        List<Integer> rankList = new ArrayList<>();
        for (DaBaoAndTuiYaoInfo s : list) {
            keshiList.add(s.getKeshi());
            valueList.add(s.getValue());
            rateList.add(s.getRate());
            rankList.add(s.getRank());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("keshiList",keshiList);
        map.put("valueList",valueList);
        map.put("rateList",rateList);
        map.put("rankList",rankList);
        map.put("sum",list.get(0).getSum());
        return map;
    }

    public static void main(String[] args) {
    }

}
