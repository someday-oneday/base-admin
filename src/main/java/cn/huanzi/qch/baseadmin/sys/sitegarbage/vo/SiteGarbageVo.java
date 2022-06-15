package cn.huanzi.qch.baseadmin.sys.sitegarbage.vo;

import cn.huanzi.qch.baseadmin.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;

@Data
public class SiteGarbageVo extends PageCondition implements Serializable {
    private String siteId;//处理回收站id

    private String siteName;//处理回收站名

    private String siteLat;//纬度

    private String siteLng;//经度

    private String siteDescription;//站点描述

    private String gId;//垃圾id

    private String gName;//垃圾名

    private String gDescribe;//垃圾描述

}
