package cn.huanzi.qch.baseadmin.sys.sysusercompany.controller;

import cn.huanzi.qch.baseadmin.annotation.Decrypt;
import cn.huanzi.qch.baseadmin.annotation.Encrypt;
import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.sys.sysusercompany.pojo.SysUserCompany;
import cn.huanzi.qch.baseadmin.sys.sysusercompany.service.SysUserCompanyService;
import cn.huanzi.qch.baseadmin.sys.sysusercompany.vo.SysUserCompanyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/info/infocompany/")
public class SysUserCompanyController extends CommonController<SysUserCompanyVo, SysUserCompany, String> {
    @Autowired
    private SysUserCompanyService sysUserCompanyService;

    @GetMapping("companylist")
    public ModelAndView companylist(){

        return new ModelAndView("info/company");
    }

    @PostMapping("findSysUserCompanyByLoginName")
    @Decrypt
    @Encrypt
    public Result<SysUserCompanyVo> findSysUserCompanyByLoginName(SysUserCompanyVo sysUserCompanyVo){
        return sysUserCompanyService.findSysUserCompanyByLoginName(sysUserCompanyVo.getLoginName());
    }

}
