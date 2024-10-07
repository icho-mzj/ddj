package com.ddj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.poi.hpsf.Decimal;

import java.io.Serializable;

/**
 * (DabaoTuiyaoSource)实体类
 *
 * @author makejava
 * @since 2024-10-05 16:27:30
 */
@Data
@TableName("dabao_tuiyao_info")
public class DaBaoAndTuiYaoInfo implements Serializable {

    private String date;
    private String keshi;
    private Integer value;
    private Double rate;
    private Integer sum;
    private Integer rank;
    private String type;


}

