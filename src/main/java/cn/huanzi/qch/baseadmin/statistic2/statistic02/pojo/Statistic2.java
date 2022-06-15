package cn.huanzi.qch.baseadmin.statistic2.statistic02.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "order2_house_community")//统计2
@Data
public class Statistic2 implements Serializable {

    private String companyId;//公司id

    private String comName;//社区名

    private String sumRweight;//该社区垃圾总重
    @Id
    private String orderId;


}
