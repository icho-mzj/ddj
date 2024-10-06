package com.ddj.common.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.fastjson.JSON;
import com.ddj.entity.YiZhuEntity;
import com.ddj.common.DateUtils;
import com.ddj.mapper.YiZhuMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: icho
 * @Date: 2024/10/4 20:56
 * @Describe:
 */
@Slf4j
@Component
public class YiZhulListener implements ReadListener<YiZhuEntity> {

    @Autowired
    private YiZhuMapper mapper;

    private final List<YiZhuEntity> list = new ArrayList<>();

    public YiZhulListener(YiZhuMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(YiZhuEntity data, AnalysisContext context) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
        data.setDate(DateUtils.cleaning(data.getDate()));
        list.add(data);
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        if (list.isEmpty()) throw new RuntimeException();

        mapper.deleteByYearAndMonth(DateUtils.getYearAndMonth(list.get(0).getDate()));
        mapper.insertAll(list);
        log.info("共{}条数据存储完成！",list.size());
    }

}
