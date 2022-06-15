package cn.huanzi.qch.baseadmin.sys.housecommunity.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "house_community")
@Data
public class HouseCommunity implements Serializable {
    @Id
    private String hId;//小区id

    private String hName;//小区名

    private String hDescription;//小区描述

    private Float lat;//经度

    private Float lng;//纬度

    private String comId;//社区id

    private String comName;//所属社区名

    private String comDescription;//社区描述

}
