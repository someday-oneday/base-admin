package cn.huanzi.qch.baseadmin.info.infogarbage.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "garbage")
@Data
public class Garbage implements Serializable {

    @Id
    private String gId;//垃圾id

    private String gName;//垃圾名

    private String gDescribe;//垃圾描述

    private String gPrice;//垃圾价格
}
