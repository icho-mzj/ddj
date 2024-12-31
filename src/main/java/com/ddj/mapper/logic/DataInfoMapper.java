package com.ddj.mapper.logic;

import com.ddj.entity.logic.DataInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: icho
 * @Date: 2024/10/8 15:17
 * @Describe:
 */
@Mapper
public interface DataInfoMapper {

    void insertInfo(@Param("date") String date, @Param("type")String type);

    void insertYizhuInfo(@Param("date") String date);

    void deleteInfo(@Param("date") String date, @Param("type")String type);

    List<DataInfo> getInfo(@Param("date")String date, @Param("type") String type, @Param("chart")String chart, @Param("sum")String sum);
}
