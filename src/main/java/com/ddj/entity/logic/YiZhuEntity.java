package com.ddj.entity.logic;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("yizhu_source")
public class YiZhuEntity {

  private String date;
  private String keshi;
  private String zhuyuanhao;
  private String yizhu;
  private String buhelileixing;
  private String heliyizhu;
  private String yisheng;
  private String beizhu;
  private String jiluren;
}
