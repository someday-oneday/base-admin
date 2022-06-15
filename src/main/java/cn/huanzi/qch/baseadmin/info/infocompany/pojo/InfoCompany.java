package cn.huanzi.qch.baseadmin.info.infocompany.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "company")
@Data
public class InfoCompany implements Serializable {
    @Id
    private String companyId;//公司id

    private String companyName;//公司名

    private String companyBusiness;//公司业务

    private String companyTel;//公司电话

}
