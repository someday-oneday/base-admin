package cn.huanzi.qch.baseadmin.statistic.statistic02.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "company_community_sumrweight")
@Data
public class CompanyCommunityRweight implements Serializable {

    private String companyName;//公司名

    private String comName;//社区名

    private String sumRweight;//该社区垃圾总重
    @Id
    private String order_Id;


}
