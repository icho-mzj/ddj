package com.ddj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * (DabaoTuiyaoSource)实体类
 *
 * @author makejava
 * @since 2024-10-05 16:27:30
 */
@Data
@TableName("dabao_tuiyao_source")
public class DaBaoAndTuiYaoSource implements Serializable {
    private static final long serialVersionUID = 677324033136990515L;

    private String date;
    private String keshi;
    private Integer value;
    private String type;
    private Double rate;
    private Integer sum;

}

