package com.ddj.mapper;

import com.ddj.entity.DaBaoAndTuiYaoInfo;
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

    List<DaBaoAndTuiYaoInfo> getInfo(@Param("date")String date, @Param("type") String type);

    void insertInfo(@Param("date")String date,@Param("type") String type);
}
