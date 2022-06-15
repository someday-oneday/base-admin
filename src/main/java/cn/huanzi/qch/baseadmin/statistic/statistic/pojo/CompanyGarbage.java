package cn.huanzi.qch.baseadmin.statistic.statistic.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "company_garbage_sumrweight")
@Data
public class CompanyGarbage implements Serializable {

    private String companyName;//公司名

    private String garbageName;//垃圾名

    private String sumRweight;//该种垃圾总重
    @Id
    private String order_Id;


}
