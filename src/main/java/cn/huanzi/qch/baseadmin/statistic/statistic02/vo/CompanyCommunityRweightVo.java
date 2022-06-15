package cn.huanzi.qch.baseadmin.statistic.statistic02.vo;

import cn.huanzi.qch.baseadmin.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;

@Data
public class CompanyCommunityRweightVo extends PageCondition implements Serializable {
    private String companyName;//公司名

    private String comName;//社区名

    private String sumRweight;//该社区垃圾总重

}
