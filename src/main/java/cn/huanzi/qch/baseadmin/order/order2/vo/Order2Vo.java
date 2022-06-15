package cn.huanzi.qch.baseadmin.order.order2.vo;

import cn.huanzi.qch.baseadmin.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;

@Data
public class Order2Vo extends PageCondition implements Serializable {
    private String orderId;//订单id

    private String userId;//用户id

    private String gId;//垃圾id

    private String hId;//小区id

    private String gotime;//上门时间

    private String gotimes;//上门时间段

    private String companyId;//公司id

    private String state;//状态

    private String late;//延期

    private String weight;//垃圾预估重量

    private String rweight;//垃圾实际重量

    private String money;//交易金额

    private String address;//详细地址

    private String ordertime;//下单时间

    private String description;//备注
}
