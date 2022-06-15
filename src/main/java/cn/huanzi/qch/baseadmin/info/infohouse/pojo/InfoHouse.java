package cn.huanzi.qch.baseadmin.info.infohouse.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "house")
@Data
public class InfoHouse implements Serializable {
    @Id
    private String hId;//小区id

    private String hName;//小区名

    private String hDescription;//小区描述

    private String comName;//所属社区名

    private Float lat;//经度

    private Float lng;//纬度

    private String com_id;//所属社区id
}
