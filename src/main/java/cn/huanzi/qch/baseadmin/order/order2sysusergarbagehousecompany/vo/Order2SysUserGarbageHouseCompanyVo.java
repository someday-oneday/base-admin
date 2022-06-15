package cn.huanzi.qch.baseadmin.order.order2sysusergarbagehousecompany.vo;

import cn.huanzi.qch.baseadmin.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;

@Data
public class Order2SysUserGarbageHouseCompanyVo extends PageCondition implements Serializable {
    private String orderId;//订单id

    private String address;//详细地址

    private String description;//订单描述

    private String gotime;//上门时间

    private String gotimes;//上门时间段

    private String late;//延期

    private String money;//交易金额

    private String ordertime;//下单时间

    private String rweight;//实际重量

    private String state;//状态

    private String weight;//预估重量

    private String companyId;//公司id

    private String userId;//用户Id

    private String loginName;//用户登录名

    private String userName;//用户名

    private String gId;//垃圾id

    private String gName;//垃圾名

    private String gDescribe;//垃圾描述

    private String gPrice;//垃圾单价

    private String hId;//小区id

    private String hDescription;//小区描述

    private String hName;//小区名

    private String companyName;//公司名

    private String companyTel;//公司电话

    private String companyBusiness;//公司业务

    private String userTelephone;//用户电话

    private String userCompanyId;//公司用户所对应的公司id

    private String lat;

    private String lng;

}
