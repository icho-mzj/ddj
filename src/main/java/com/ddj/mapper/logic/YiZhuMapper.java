package com.ddj.mapper.logic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ddj.entity.logic.YiZhuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: icho
 * @Date: 2024/10/4 14:14
 * @Describe:
 */
@Mapper
public interface YiZhuMapper extends BaseMapper<YiZhuEntity> {

    void insertAll(List<YiZhuEntity> list);

    void deleteSource(String date);

}
