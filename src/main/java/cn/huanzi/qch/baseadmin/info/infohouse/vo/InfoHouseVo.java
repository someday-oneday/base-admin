package cn.huanzi.qch.baseadmin.info.infohouse.vo;

import cn.huanzi.qch.baseadmin.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;

@Data
public class InfoHouseVo extends PageCondition implements Serializable {
    private String hId;//小区id

    private String hName;//小区名

    private String hDescription;//小区描述

    private String comName;//所属社区名

    private Float lat;//经度

    private Float lng;//纬度

    private String com_id;//所属社区id

}
