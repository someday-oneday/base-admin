package cn.huanzi.qch.baseadmin.statistic2.statistic.service;

import cn.huanzi.qch.baseadmin.common.pojo.PageInfo;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.common.service.CommonServiceImpl;
import cn.huanzi.qch.baseadmin.statistic2.statistic.pojo.Statistic1;
import cn.huanzi.qch.baseadmin.statistic2.statistic.repository.Statistic1Respository;
import cn.huanzi.qch.baseadmin.statistic2.statistic.vo.Statistic1Vo;
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
public class Statistic1ServiceImpl extends CommonServiceImpl<Statistic1Vo, Statistic1, String> implements Statistic1Service {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private Statistic1Respository statistic1Respository;

    @Override
    public Result<PageInfo<Statistic1Vo>> page(Statistic1Vo entityVo) {
        //这里可以直接调父类的page方法，当然也可以像下面这样自定义SQL
        //Result<PageInfo<SysUserVo>> result = super.page(entityVo);

        //根据实体、Vo直接拼接全部SQL
        StringBuilder sql = SqlUtil.joinSqlByEntityAndVo(Statistic1.class,entityVo);

        //设置SQL、映射实体，以及设置值，返回一个Query对象
        Query query = em.createNativeQuery(sql.toString(), Statistic1.class);

        //分页设置，page从0开始
        PageRequest pageRequest = entityVo.getPageable();

        //获取最终分页结果
        Result<PageInfo<Statistic1Vo>> result = Result.of(PageInfo.of(PageInfo.getJpaPage(query, pageRequest,em), Statistic1Vo.class));

        //置空密码
        //result.getData().getRows().forEach((orderVo) -> orderVo.setGarbageName(null));
        return result;
    }


    @Override
    public Result<List<Statistic1Vo>> findStatistic1sByCompanyId(String companyId) {
        return Result.of(CopyUtil.copyList(statistic1Respository.findStatistic1sByCompanyId(companyId), Statistic1Vo.class));
    }
}
