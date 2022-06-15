package cn.huanzi.qch.baseadmin.info.infosite.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "site")
@Data
public class InfoSite implements Serializable {

    @Id
    private String siteId;//回收站id

    private String siteName;//回收站名

    private String siteGarbage;//回收站回收垃圾种类

    private String siteLng;//经度

    private String siteLat;//纬度

    private String siteDescription;//站点描述
}
