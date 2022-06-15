package cn.huanzi.qch.baseadmin.info.infocommunity.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "community")
@Data
public class Community implements Serializable {

    @Id
    private String comId;//社区id

    private String comName;//社区名

    private String comDescription;//社区描述
}
