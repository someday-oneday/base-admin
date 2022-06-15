package cn.huanzi.qch.baseadmin.info.infocompany.vo;

import cn.huanzi.qch.baseadmin.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;

@Data
public class InfoCompanyVo extends PageCondition implements Serializable {
    private String companyId;//公司id

    private String companyName;//公司名

    private String companyBusiness;//公司业务

    private String companyTel;//公司电话

}
