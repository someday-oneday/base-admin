package cn.huanzi.qch.baseadmin.sys.housecommunity.vo;

import cn.huanzi.qch.baseadmin.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;

@Data
public class HouseCommunityVo extends PageCondition implements Serializable {
    private String hId;//小区id

    private String hName;//小区名

    private String hDescription;//小区描述

    private Float lat;//经度

    private Float lng;//纬度

    private String comId;//社区id

    private String comName;//所属社区名

    private String comDescription;//社区描述

}
