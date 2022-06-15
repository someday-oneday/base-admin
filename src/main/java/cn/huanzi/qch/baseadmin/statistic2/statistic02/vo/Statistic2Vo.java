package cn.huanzi.qch.baseadmin.statistic2.statistic02.vo;

import cn.huanzi.qch.baseadmin.common.pojo.PageCondition;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class Statistic2Vo extends PageCondition implements Serializable {
    private String companyId;//公司id

    private String comName;//社区名

    private String sumRweight;//该社区垃圾总重

    private String orderId;

}
