package com.ddj.common.constant;

import lombok.Data;

/**
 * @Author: icho
 * @Date: 2024/10/5 14:47
 * @Describe:
 */
public enum KeShiEnum {
    JIZHU1("骨伤科脊柱·肿瘤一组病区"),
    JIZHU2("骨伤科脊柱·肿瘤二组病区"),
    CHUANGSHANG1("骨伤科创伤组一病区"),
    CHUANGSHANG2("骨伤科创伤组二病区"),
    GUANJIE1("骨伤科关节·足踝组一病区"),
    GUANJIE2("骨伤科关节·足踝组二病区"),
    SHOUWAI("骨伤手外·儿骨·烧伤整形病区"),
    GANGCHANG1("肛肠科一病区"),
    GANGCHANG2("肛肠科二病区"),
    GANDANYI("肝胆胰外科病区"),
    SHENWAI("神经外科病区"),
    PUWAI("普外·疝与腹壁外科病区"),
    XIONGXIN("胸心外科病区"),
    MINIAO("泌尿外科病区"),
    XUEGUAN("乳腺·甲状腺·血管外科病区"),
    ZHONGLIU2A("肿瘤·血液病科病区(忠山院区)A区"),
    ZHONGLIU2B("肿瘤·血液病科病区(忠山院区)B区"),
    ZHONGLIU2C("肿瘤·血液病科病区(忠山院区)C区"),
    JIZHEN("城北急诊科病区"),
    ERBIHOU("耳鼻咽喉科病区"),
    GANDANNEI("肝胆病科病区"),
    YANKE("眼科病区"),
    VIP1("全科医学·VIP病房一病区"),
    VIP2("全科医学·VIP病房二病区"),
    ZHONGYI("中医经典病区"),
    LAONIAN("老年病科病区"),
    PIFU("皮肤科病区"),
    NEIFENMI("内分泌代谢科病区"),
    ZHONGLIU1A("肿瘤·血液病科病区(城北院区)A区"),
    ZHONGLIU1B("肿瘤·血液病科病区(城北院区)B区"),
    FU1("妇科一病区"),
    FU2("妇科二病区"),
    CHAN1("产科一病区"),
    CHAN2("产科二病区"),
    XINNEI1("心血管内科一病区"),
    XINNEI2("心血管内科二病区"),
    SHENNEI1("神经内科一病区"),
    SHENNEI2("神经内科二病区"),
    CCU("CCU/NICU病区"),
    SHENBING("肾病科病区"),
    HUXI("呼吸内科病区"),
    PIWEI1("脾胃·风湿免疫病科一病区"),
    PIWEI2("脾胃·风湿免疫病科二病区"),
    ERKE("儿科病区"),
    XINSHENGERKE("新生儿科病区");

    private String name;

    KeShiEnum(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}
