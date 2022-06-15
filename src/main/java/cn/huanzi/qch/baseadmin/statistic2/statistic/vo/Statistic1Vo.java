package cn.huanzi.qch.baseadmin.statistic2.statistic.vo;

import cn.huanzi.qch.baseadmin.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;

@Data
public class Statistic1Vo extends PageCondition implements Serializable {
    private String companyId;//公司id

    private String gName;//垃圾名

    private String sumRweight;//该种垃圾总重

    private String order_Id;

}
