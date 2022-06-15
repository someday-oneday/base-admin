package cn.huanzi.qch.baseadmin.sys.carcompany.vo;

import cn.huanzi.qch.baseadmin.annotation.Like;
import cn.huanzi.qch.baseadmin.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CarCompanyVo extends PageCondition implements Serializable {
    private String carId;//车辆id

    private String carName;//车辆名

    private Integer carLoad;//车辆载重

    private Integer carNumber;//车辆数目

    private String companyId;//所属单位id

    private String companyName;//公司名

    private String companyBusiness;//公司业务

    private String companyTel;//公司电话

}
