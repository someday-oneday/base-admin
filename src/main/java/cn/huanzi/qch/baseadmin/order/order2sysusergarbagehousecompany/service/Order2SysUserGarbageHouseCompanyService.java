package cn.huanzi.qch.baseadmin.order.order2sysusergarbagehousecompany.service;

import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.common.service.CommonService;
import cn.huanzi.qch.baseadmin.order.order2sysusergarbagehousecompany.pojo.Order2SysUserGarbageHouseCompany;
import cn.huanzi.qch.baseadmin.order.order2sysusergarbagehousecompany.vo.Order2SysUserGarbageHouseCompanyVo;

import java.util.List;

public interface Order2SysUserGarbageHouseCompanyService extends CommonService<Order2SysUserGarbageHouseCompanyVo, Order2SysUserGarbageHouseCompany, String> {
//    Result<List<Order2Vo>> findOrdersByGarbageName(String garbageName);
//    Result<List<Order2Vo>> findOrdersByStateAndGotime(String state, String gotime);
//    Result<List<Order2Vo>> findOrdersByCompanyNameAndStateAndGotime(String companyName, String state, String gotime);

    Result<List<Order2SysUserGarbageHouseCompanyVo>> findOrder2SysUserGarbageHouseCompanyByCompanyIdAndGotime(String companyId, String gotime);

//    Result<List<Order2SysUserGarbageHouseCompanyVo>> findOrder2SysUserGarbageHouseCompanyByCompanyIdAndGotimeAndgAndGotimes(String companyId, String gotime, String gotimes);
}
