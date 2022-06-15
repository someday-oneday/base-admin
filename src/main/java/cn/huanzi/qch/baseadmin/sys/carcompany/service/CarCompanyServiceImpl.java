package cn.huanzi.qch.baseadmin.sys.carcompany.service;

import cn.huanzi.qch.baseadmin.common.pojo.PageInfo;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.common.service.CommonServiceImpl;
import cn.huanzi.qch.baseadmin.eventlistener.eventsource.SecurityMetadataSourceEventSource;
import cn.huanzi.qch.baseadmin.sys.carcompany.pojo.CarCompany;
import cn.huanzi.qch.baseadmin.sys.carcompany.repository.CarCompanyRepository;
import cn.huanzi.qch.baseadmin.sys.carcompany.vo.CarCompanyVo;
import cn.huanzi.qch.baseadmin.sys.sysauthority.pojo.SysAuthority;
import cn.huanzi.qch.baseadmin.sys.sysauthority.repository.SysAuthorityRepository;
import cn.huanzi.qch.baseadmin.sys.sysauthority.vo.SysAuthorityVo;
import cn.huanzi.qch.baseadmin.sys.sysuserauthority.service.SysUserAuthorityService;
import cn.huanzi.qch.baseadmin.sys.sysuserauthority.vo.SysUserAuthorityVo;
import cn.huanzi.qch.baseadmin.sys.sysusercompany.pojo.SysUserCompany;
import cn.huanzi.qch.baseadmin.sys.sysusercompany.vo.SysUserCompanyVo;
import cn.huanzi.qch.baseadmin.util.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
@Transactional
public class CarCompanyServiceImpl extends CommonServiceImpl<CarCompanyVo, CarCompany, String> implements CarCompanyService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private CarCompanyRepository carCompanyRepository;

    @Autowired
    private CarCompanyService carCompanyService;

    @Override
    public Result<PageInfo<CarCompanyVo>> page(CarCompanyVo entityVo) {
        //这里可以直接调父类的page方法，当然也可以像下面这样自定义SQL
        //Result<PageInfo<SysUserVo>> result = super.page(entityVo);

        //根据实体、Vo直接拼接全部SQL
        StringBuilder sql = SqlUtil.joinSqlByEntityAndVo(CarCompany.class, entityVo);

        //设置SQL、映射实体，以及设置值，返回一个Query对象
        Query query = em.createNativeQuery(sql.toString(), CarCompany.class);

        //分页设置，page从0开始
        PageRequest pageRequest = entityVo.getPageable();

        //获取最终分页结果
        Result<PageInfo<CarCompanyVo>> result = Result.of(PageInfo.of(PageInfo.getJpaPage(query, pageRequest, em), CarCompanyVo.class));

        //置空密码
        //result.getData().getRows().forEach((orderVo) -> orderVo.setGarbageName(null));
        return result;

    }
}
