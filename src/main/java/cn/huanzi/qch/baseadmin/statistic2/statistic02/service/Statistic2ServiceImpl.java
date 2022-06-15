package cn.huanzi.qch.baseadmin.statistic2.statistic02.service;

import cn.huanzi.qch.baseadmin.common.pojo.PageInfo;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.common.service.CommonServiceImpl;
import cn.huanzi.qch.baseadmin.statistic2.statistic02.pojo.Statistic2;
import cn.huanzi.qch.baseadmin.statistic2.statistic02.repository.Statistic2Respository;
import cn.huanzi.qch.baseadmin.statistic2.statistic02.vo.Statistic2Vo;
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
public class Statistic2ServiceImpl extends CommonServiceImpl<Statistic2Vo, Statistic2, String> implements Statistic2Service {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private Statistic2Respository statistic2Respository;

    @Override
    public Result<PageInfo<Statistic2Vo>> page(Statistic2Vo entityVo) {
        //这里可以直接调父类的page方法，当然也可以像下面这样自定义SQL
        //Result<PageInfo<SysUserVo>> result = super.page(entityVo);

        //根据实体、Vo直接拼接全部SQL
        StringBuilder sql = SqlUtil.joinSqlByEntityAndVo(Statistic2.class,entityVo);

        //设置SQL、映射实体，以及设置值，返回一个Query对象
        Query query = em.createNativeQuery(sql.toString(), Statistic2.class);

        //分页设置，page从0开始
        PageRequest pageRequest = entityVo.getPageable();

        //获取最终分页结果
        Result<PageInfo<Statistic2Vo>> result = Result.of(PageInfo.of(PageInfo.getJpaPage(query, pageRequest,em), Statistic2Vo.class));

        //置空密码
        //result.getData().getRows().forEach((orderVo) -> orderVo.setGarbageName(null));
        return result;
    }


    @Override
    public Result<List<Statistic2Vo>> findStatistic2sByCompanyId(String companyId) {
        return Result.of(CopyUtil.copyList(statistic2Respository.findStatistic2sByCompanyId(companyId), Statistic2Vo.class));
    }
}
