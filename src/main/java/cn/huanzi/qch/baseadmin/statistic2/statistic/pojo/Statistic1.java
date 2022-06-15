package cn.huanzi.qch.baseadmin.statistic2.statistic.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "company_garbage_sumrweight2")//统计1
@Data
public class Statistic1 implements Serializable {

    private String companyId;//公司id

    private String gName;//垃圾名

    private String sumRweight;//该种垃圾总重
    @Id
    private String order_Id;


}
