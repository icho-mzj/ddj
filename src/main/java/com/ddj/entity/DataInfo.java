package com.ddj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * (DabaoTuiyaoSource)实体类
 *
 * @author makejava
 * @since 2024-10-05 16:27:30
 */
@Data
@TableName("data_info")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataInfo implements Serializable {

    private String date;
    private String name;
    private Integer value;
    private Double rate;
    private Integer sum;
    private Integer rank;
    private String type;
}

