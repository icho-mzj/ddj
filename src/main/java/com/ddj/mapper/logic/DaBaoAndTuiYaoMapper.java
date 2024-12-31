package com.ddj.mapper.logic;

import com.ddj.entity.logic.DaBaoAndTuiYaoSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: icho
 * @Date: 2024/10/5 13:17
 * @Describe:
 */
@Mapper
public interface DaBaoAndTuiYaoMapper {

    void insertAll(List<DaBaoAndTuiYaoSource> list);

    void deleteSource(@Param("date") String date, @Param("type") String type);

}
