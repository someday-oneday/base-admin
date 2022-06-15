package cn.huanzi.qch.baseadmin.info.infocar.vo;

import cn.huanzi.qch.baseadmin.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;

@Data
public class InfoCarVo extends PageCondition implements Serializable {
    private String carId;//车辆id

    private String carName;//车辆名

    private Integer carLoad;//车辆载重

    private Integer carNumber;//车辆数目

    private String companyId;//所属单位id

    private String gId;//垃圾id

}
