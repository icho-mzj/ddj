package com.ddj.mapper;

import com.ddj.entity.DaBaoAndTuiYaoSource;
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

    void deleteByYearAndMonth(@Param("date") String date, @Param("type")String type);

    List<DaBaoAndTuiYaoSource> getData(@Param("date")String date,@Param("type") String type);
}
