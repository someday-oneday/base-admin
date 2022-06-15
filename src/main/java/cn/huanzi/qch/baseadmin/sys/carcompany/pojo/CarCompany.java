package cn.huanzi.qch.baseadmin.sys.carcompany.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "car_company")
@Data
public class CarCompany implements Serializable {
    @Id
    private String carId;//车辆id

    private String carName;//车辆名

    private Integer carLoad;//车辆载重

    private Integer carNumber;//车辆数目

    private String companyId;//所属单位id

    private String companyName;//公司名

    private String companyBusiness;//公司业务

    private String companyTel;//公司电话

}
