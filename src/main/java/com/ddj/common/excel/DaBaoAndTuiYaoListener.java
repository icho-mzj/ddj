package com.ddj.common.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import com.ddj.common.constant.KeShiEnum;
import com.ddj.common.DateUtils;
import com.ddj.entity.DaBaoAndTuiYaoSource;
import com.ddj.mapper.DaBaoAndTuiYaoMapper;
import com.ddj.service.DaBaoAndTuiYaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: icho
 * @Date: 2024/10/5 13:09
 * @Describe:
 */
@Slf4j
@Component
public class DaBaoAndTuiYaoListener implements ReadListener<Map<Integer, String>> {

    @Autowired
    private DaBaoAndTuiYaoMapper mapper;

    @Autowired
    private DaBaoAndTuiYaoService service;

    /**
     * 每隔100条存储数据库，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;

    private List<DaBaoAndTuiYaoSource> list1 = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    List<String> list2 = new ArrayList<>();

    public DaBaoAndTuiYaoListener(DaBaoAndTuiYaoMapper mapper,DaBaoAndTuiYaoService service) {
        this.mapper = mapper;
        this.service = service;
    }


    public void invoke(Map<Integer, String> data, AnalysisContext context) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
        setData(data);
        if (list1.size() >= BATCH_COUNT) {
            mapper.insertAll(list1);
            list1 = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    void setData(Map<Integer, String> data) {
        Arrays.stream(KeShiEnum.values()).forEach(v->list2.add(v.toString()));
        for (int i = 0; i < list2.size(); i++) {
            DaBaoAndTuiYaoSource s = new DaBaoAndTuiYaoSource();
            s.setKeshi(list2.get(i));
            String value = data.get(i + 1);
            if (value==null) value = "0";
            s.setValue(Integer.valueOf(value));
            s.setType(service.getType());
            s.setDate(DateUtils.cleaning(data.get(0)));
            list1.add(s);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        if (!list1.isEmpty()){ mapper.insertAll(list1);}
        log.info("数据存储完成！");
    }
}

