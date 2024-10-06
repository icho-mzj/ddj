package com.ddj.common.constant;

import lombok.Data;

/**
 * @Author: icho
 * @Date: 2024/10/5 14:47
 * @Describe:
 */
public enum KeShiEnum {
    JIZHU1("脊柱1"),
    JIZHU2("脊柱2"),
    CHUANGSHANG1("创伤一"),
    CHUANGSHANG2("创伤二"),
    GUANJIE1("关节一"),
    GUANJIE2("关节二"),
    SHOUWAI("手外"),
    GANGCHANG1("肛肠一"),
    GANGCHANG2("肛肠二"),
    GANDANYI("肝胆胰"),
    SHENWAI("神外"),
    PUWAI("普外"),
    XIONGXIN("胸心"),
    MINIAO("泌尿"),
    XUEGUAN("血管"),
    ZHONGLIU2A("肿瘤二A"),
    ZHONGLIU2B("肿瘤二B"),
    ZHONGLIU2C("肿瘤二C"),
    JIZHEN("急诊"),
    ERBIHOU("耳鼻喉"),
    GANDANNEI("肝胆内"),
    YANKE("眼科"),
    VIP1("VIP一"),
    VIP2("VIP二"),
    ZHONGYI("中医"),
    LAONIAN("老年"),
    PIFU("皮肤"),
    NEIFENMI("内分泌"),
    ZHONGLIU1A("肿瘤一A"),
    ZHONGLIU1B("肿瘤一B"),
    FU1("妇一"),
    FU2("妇二"),
    CHAN1("产一"),
    CHAN2("产二"),
    XINNEI1("心内一"),
    XINNEI2("心内二"),
    SHENNEI1("神内一"),
    SHENNEI2("神内二"),
    CCU("CCU"),
    SHENBING("肾病"),
    HUXI("呼吸"),
    PIWEI1("脾胃一"),
    PIWEI2("脾胃二"),
    ERKE("儿科"),
    XINSHENGERKE("新生儿科");

    private String name;

    KeShiEnum(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}
