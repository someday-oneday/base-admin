package cn.huanzi.qch.baseadmin.statistic.statistic.vo;

import cn.huanzi.qch.baseadmin.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;

@Data
public class CompanyGarbageVo extends PageCondition implements Serializable {
    private String companyName;//公司名

    private String garbageName;//垃圾名

    private String sumRweight;//该种垃圾总重

}
