package cn.huanzi.qch.baseadmin.sys.sysusercompany.service;

import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.common.service.CommonService;
import cn.huanzi.qch.baseadmin.sys.sysusercompany.pojo.SysUserCompany;
import cn.huanzi.qch.baseadmin.sys.sysusercompany.vo.SysUserCompanyVo;

import java.util.List;

public interface SysUserCompanyService extends CommonService<SysUserCompanyVo, SysUserCompany, String> {
    Result<SysUserCompanyVo> findSysUserCompanyByLoginName(String loginName);
}
