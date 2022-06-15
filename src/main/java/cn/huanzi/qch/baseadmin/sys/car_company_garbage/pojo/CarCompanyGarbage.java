package cn.huanzi.qch.baseadmin.sys.car_company_garbage.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "car_company_garbage")
@Data
public class CarCompanyGarbage implements Serializable {
    @Id
    private String carId;//车辆id

    private String carName;//车辆名

    private Integer carLoad;//车辆载重

    private Integer carNumber;//车辆数目

    private String companyId;//所属单位id

    private String companyName;//公司名

    private String companyBusiness;//公司业务

    private String companyTel;//公司电话

    private String gId;//垃圾id

    private String gName;//垃圾名

    private String gPrice;//垃圾单价

    private String gDescribe;//垃圾描述
}
