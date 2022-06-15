package cn.huanzi.qch.baseadmin.statistic.statistic02.service;

import cn.huanzi.qch.baseadmin.common.pojo.PageInfo;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.common.service.CommonServiceImpl;
import cn.huanzi.qch.baseadmin.statistic.statistic02.pojo.CompanyCommunityRweight;
import cn.huanzi.qch.baseadmin.statistic.statistic02.repository.CompanyCommunityRweightRespository;
import cn.huanzi.qch.baseadmin.statistic.statistic02.vo.CompanyCommunityRweightVo;
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
public class CompanyCommunityRweightServiceImpl extends CommonServiceImpl<CompanyCommunityRweightVo, CompanyCommunityRweight, String> implements CompanyCommunityRweightService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private CompanyCommunityRweightRespository companyCommunityRweightRespository;

    @Override
    public Result<PageInfo<CompanyCommunityRweightVo>> page(CompanyCommunityRweightVo entityVo) {
        //这里可以直接调父类的page方法，当然也可以像下面这样自定义SQL
        //Result<PageInfo<SysUserVo>> result = super.page(entityVo);

        //根据实体、Vo直接拼接全部SQL
        StringBuilder sql = SqlUtil.joinSqlByEntityAndVo(CompanyCommunityRweight.class,entityVo);

        //设置SQL、映射实体，以及设置值，返回一个Query对象
        Query query = em.createNativeQuery(sql.toString(), CompanyCommunityRweight.class);

        //分页设置，page从0开始
        PageRequest pageRequest = entityVo.getPageable();

        //获取最终分页结果
        Result<PageInfo<CompanyCommunityRweightVo>> result = Result.of(PageInfo.of(PageInfo.getJpaPage(query, pageRequest,em), CompanyCommunityRweightVo.class));

        //置空密码
        //result.getData().getRows().forEach((orderVo) -> orderVo.setGarbageName(null));
        return result;
    }


    @Override
    public Result<List<CompanyCommunityRweightVo>> findCompanyCommunityRweightsByCompanyName(String companyName) {
        return Result.of(CopyUtil.copyList(companyCommunityRweightRespository.findCompanyCommunityRweightsByCompanyName(companyName), CompanyCommunityRweightVo.class));
    }
}
