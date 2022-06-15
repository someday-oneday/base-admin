package cn.huanzi.qch.baseadmin.order.order2sysusergarbagehousecompany.repository;

import cn.huanzi.qch.baseadmin.common.repository.CommonRepository;
import cn.huanzi.qch.baseadmin.order.order2sysusergarbagehousecompany.pojo.Order2SysUserGarbageHouseCompany;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Order2SysUserGarbageHouseCompanyRespository extends CommonRepository<Order2SysUserGarbageHouseCompany, String> {
//    List<Order2> findOrdersByGarbageName(String garbageName);

//    List<Order2> findOrdersByStateAndGotime(String state, String gotime);

//    List<Order2> findOrdersByCompanyNameAndStateAndGotime(String companyName, String state, String gotime);

    List<Order2SysUserGarbageHouseCompany> findOrder2SysUserGarbageHouseCompanyByCompanyIdAndGotime(String companyId, String gotime);

//    List<Order2SysUserGarbageHouseCompany> findOrder2SysUserGarbageHouseCompanyByCompanyIdAndGotimeAndgAndGotimes(String companyId, String gotime, String gotimes);

}
