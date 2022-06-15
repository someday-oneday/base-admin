package cn.huanzi.qch.baseadmin.sys.sitegarbage.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "site_garbage")
@Data
public class SiteGarbage implements Serializable {
    @Id
    private String siteId;//处理回收站id

    private String siteName;//处理回收站名

    private String siteLat;//纬度

    private String siteLng;//经度

    private String siteDescription;//站点描述

    private String gId;//垃圾id

    private String gName;//垃圾名

    private String gDescribe;//垃圾描述
}
