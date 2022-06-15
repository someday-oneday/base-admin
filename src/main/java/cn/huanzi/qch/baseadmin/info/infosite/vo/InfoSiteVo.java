package cn.huanzi.qch.baseadmin.info.infosite.vo;

import cn.huanzi.qch.baseadmin.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;

@Data
public class InfoSiteVo extends PageCondition implements Serializable {
    private String siteId;//回收站id

    private String siteName;//回收站名

    private String siteGarbage;//回收站回收垃圾种类

    private String siteLng;//经度

    private String siteLat;//纬度

    private String siteDescription;//站点描述

}
