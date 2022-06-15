package cn.huanzi.qch.baseadmin.sys.sysusercompany.service;

import cn.huanzi.qch.baseadmin.common.pojo.PageInfo;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.common.service.CommonServiceImpl;
import cn.huanzi.qch.baseadmin.sys.sysusercompany.pojo.SysUserCompany;
import cn.huanzi.qch.baseadmin.sys.sysusercompany.repository.SysUserCompanyRepository;
import cn.huanzi.qch.baseadmin.sys.sysusercompany.vo.SysUserCompanyVo;
import cn.huanzi.qch.baseadmin.util.CopyUtil;
import cn.huanzi.qch.baseadmin.util.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Service
@Transactional
public class SysUserCompanyServiceImpl extends CommonServiceImpl<SysUserCompanyVo, SysUserCompany, String> implements SysUserCompanyService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private SysUserCompanyRepository sysUserRepository;

    @Override
    public Result<PageInfo<SysUserCompanyVo>> page(SysUserCompanyVo entityVo) {
        //这里可以直接调父类的page方法，当然也可以像下面这样自定义SQL
        //Result<PageInfo<SysUserVo>> result = super.page(entityVo);

        //根据实体、Vo直接拼接全部SQL
        StringBuilder sql = SqlUtil.joinSqlByEntityAndVo(SysUserCompany.class,entityVo);

        //设置SQL、映射实体，以及设置值，返回一个Query对象
        Query query = em.createNativeQuery(sql.toString(), SysUserCompany.class);

        //分页设置，page从0开始
        PageRequest pageRequest = entityVo.getPageable();

        //获取最终分页结果
        Result<PageInfo<SysUserCompanyVo>> result = Result.of(PageInfo.of(PageInfo.getJpaPage(query, pageRequest,em), SysUserCompanyVo.class));

        //置空密码
        //result.getData().getRows().forEach((orderVo) -> orderVo.setGarbageName(null));
        return result;
    }

    @Override
    public Result<SysUserCompanyVo> findSysUserCompanyByLoginName(String loginName) {
        return Result.of(CopyUtil.copy(sysUserRepository.findSysUserCompanyByLoginName(loginName), SysUserCompanyVo.class));

    }
//@Override
//    public Result<List<SysUserCompany>> findCompanyUser() {
//        if (!(sysUserCompanyVo instanceof PageCondition)) {
//            throw new RuntimeException("缺失分页参数！");
//        }
//        PageCondition pageCondition = (PageCondition) sysUserCompanyVo;
        //先entityVo转entity，再调用findAll（传多一个分页参数），结果集再转回entityVo
//    List<SysUserCompany> a = sysUserRepository.findCompanyUser();
//        return Result.of(a);
//    EntityManagerFactory entityManagerFactory =    Persistence.createEntityManagerFactory("");
//    List<SysUserCompany> sysUserCompanys = entityManagerFactory.createEntityManager().createNativeQuery("select u.*,c.* from sys_user u right JOIN company c on u.company_id=c.company_id",SysUserCompany.class).getResultList();
//        return Result.of(sysUserCompanys);

//    }

}
