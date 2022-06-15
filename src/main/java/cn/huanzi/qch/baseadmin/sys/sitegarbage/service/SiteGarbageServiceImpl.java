package cn.huanzi.qch.baseadmin.sys.sitegarbage.service;

import cn.huanzi.qch.baseadmin.common.pojo.PageInfo;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.common.service.CommonServiceImpl;
import cn.huanzi.qch.baseadmin.sys.sitegarbage.pojo.SiteGarbage;
import cn.huanzi.qch.baseadmin.sys.sitegarbage.repository.SiteGarbageRepository;
import cn.huanzi.qch.baseadmin.sys.sitegarbage.vo.SiteGarbageVo;
import cn.huanzi.qch.baseadmin.util.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
@Transactional
public class SiteGarbageServiceImpl extends CommonServiceImpl<SiteGarbageVo, SiteGarbage, String> implements SiteGarbageService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SiteGarbageRepository houseCommunityRepository;

    @Autowired
    private SiteGarbageService houseCommunityService;

    @Override
    public Result<PageInfo<SiteGarbageVo>> page(SiteGarbageVo entityVo) {
        //这里可以直接调父类的page方法，当然也可以像下面这样自定义SQL
        //Result<PageInfo<SysUserVo>> result = super.page(entityVo);

        //根据实体、Vo直接拼接全部SQL
        StringBuilder sql = SqlUtil.joinSqlByEntityAndVo(SiteGarbage.class, entityVo);

        //设置SQL、映射实体，以及设置值，返回一个Query对象
        Query query = em.createNativeQuery(sql.toString(), SiteGarbage.class);

        //分页设置，page从0开始
        PageRequest pageRequest = entityVo.getPageable();

        //获取最终分页结果
        Result<PageInfo<SiteGarbageVo>> result = Result.of(PageInfo.of(PageInfo.getJpaPage(query, pageRequest, em), SiteGarbageVo.class));

        //置空密码
        //result.getData().getRows().forEach((orderVo) -> orderVo.setGarbageName(null));
        return result;

    }
}
