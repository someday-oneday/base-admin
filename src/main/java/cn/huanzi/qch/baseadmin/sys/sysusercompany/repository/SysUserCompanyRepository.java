package cn.huanzi.qch.baseadmin.sys.sysusercompany.repository;

import cn.huanzi.qch.baseadmin.common.repository.CommonRepository;
import cn.huanzi.qch.baseadmin.sys.sysuser.pojo.SysUser;
import cn.huanzi.qch.baseadmin.sys.sysusercompany.pojo.SysUserCompany;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserCompanyRepository extends CommonRepository<SysUserCompany, String> {
    //@Query(value = "select  u.userName,c.companyName from SysUser u right JOIN InfoCompany c on u.companyId=c.companyId")
//    List<SysUserCompany> findSysUserCompaniesBy();
    SysUserCompany findSysUserCompanyByLoginName(String loginName);
}
