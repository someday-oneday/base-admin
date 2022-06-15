package cn.huanzi.qch.baseadmin.order.order2sysusergarbagehousecompany.service;

import cn.huanzi.qch.baseadmin.common.pojo.PageInfo;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.common.service.CommonServiceImpl;
import cn.huanzi.qch.baseadmin.order.order2sysusergarbagehousecompany.pojo.Order2SysUserGarbageHouseCompany;
import cn.huanzi.qch.baseadmin.order.order2sysusergarbagehousecompany.repository.Order2SysUserGarbageHouseCompanyRespository;
import cn.huanzi.qch.baseadmin.order.order2sysusergarbagehousecompany.vo.Order2SysUserGarbageHouseCompanyVo;
import cn.huanzi.qch.baseadmin.util.CopyUtil;
import cn.huanzi.qch.baseadmin.util.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
@Transactional
public class Order2SysUserGarbageHouseCompanyServiceImpl extends CommonServiceImpl<Order2SysUserGarbageHouseCompanyVo, Order2SysUserGarbageHouseCompany, String> implements Order2SysUserGarbageHouseCompanyService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private Order2SysUserGarbageHouseCompanyRespository order2SysUserGarbageHouseCompanyRespository;


//    @Override
//    public Result<List<Order2Vo>> findOrdersByGarbageName(String garbageName) {
//        return Result.of(CopyUtil.copyList(orderRespository.findOrdersByGarbageName(garbageName), Order2Vo.class));
//    }
//
//    @Override
//    public Result<List<Order2Vo>> findOrdersByStateAndGotime(String state, String gotime) {
//        return Result.of(CopyUtil.copyList(orderRespository.findOrdersByStateAndGotime(state,gotime), Order2Vo.class));
//    }
//
//    @Override
//    public Result<List<Order2Vo>> findOrdersByCompanyNameAndStateAndGotime(String companyName, String state, String gotime) {
//        return Result.of(CopyUtil.copyList(orderRespository.findOrdersByCompanyNameAndStateAndGotime(companyName,state,gotime), Order2Vo.class));
//    }


    @Override
    public Result<PageInfo<Order2SysUserGarbageHouseCompanyVo>> page(Order2SysUserGarbageHouseCompanyVo entityVo) {
        //这里可以直接调父类的page方法，当然也可以像下面这样自定义SQL
        //Result<PageInfo<SysUserVo>> result = super.page(entityVo);

        //根据实体、Vo直接拼接全部SQL
        StringBuilder sql = SqlUtil.joinSqlByEntityAndVo(Order2SysUserGarbageHouseCompany.class,entityVo);

        //设置SQL、映射实体，以及设置值，返回一个Query对象
        Query query = em.createNativeQuery(sql.toString(), Order2SysUserGarbageHouseCompany.class);

        //分页设置，page从0开始
        PageRequest pageRequest = entityVo.getPageable();

        //获取最终分页结果
        Result<PageInfo<Order2SysUserGarbageHouseCompanyVo>> result = Result.of(PageInfo.of(PageInfo.getJpaPage(query, pageRequest,em), Order2SysUserGarbageHouseCompanyVo.class));

        //置空密码
        //result.getData().getRows().forEach((orderVo) -> orderVo.setGarbageName(null));
        return result;
    }

    @Override
    public Result<List<Order2SysUserGarbageHouseCompanyVo>> findOrder2SysUserGarbageHouseCompanyByCompanyIdAndGotime(String companyId, String gotime) {
        return Result.of(CopyUtil.copyList(order2SysUserGarbageHouseCompanyRespository.findOrder2SysUserGarbageHouseCompanyByCompanyIdAndGotime(companyId,gotime), Order2SysUserGarbageHouseCompanyVo.class));
    }

//    @Override
//    public Result<List<Order2SysUserGarbageHouseCompanyVo>> findOrder2SysUserGarbageHouseCompanyByCompanyIdAndGotimeAndgAndGotimes(String companyId, String gotime, String gotimes) {
//        return Result.of(CopyUtil.copyList(order2SysUserGarbageHouseCompanyRespository.findOrder2SysUserGarbageHouseCompanyByCompanyIdAndGotimeAndgAndGotimes(companyId,gotime,gotimes), Order2SysUserGarbageHouseCompanyVo.class));
//    }
}
