package cn.huanzi.qch.baseadmin.info.infocompany.controller;

import cn.huanzi.qch.baseadmin.annotation.Decrypt;
import cn.huanzi.qch.baseadmin.annotation.Encrypt;
import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.info.infocompany.pojo.InfoCompany;
import cn.huanzi.qch.baseadmin.info.infocompany.service.InfoCompanyService;
import cn.huanzi.qch.baseadmin.info.infocompany.vo.InfoCompanyVo;
import cn.huanzi.qch.baseadmin.sys.sysuser.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/registerCompany/")
public class RegisterCompanyController extends CommonController<InfoCompanyVo, InfoCompany, String> {

    @Autowired
    private InfoCompanyService infoCompanyService;

    @PostMapping("findInfoCompaniesByCompanyName")
    @Decrypt
    @Encrypt
    public Result<List<InfoCompanyVo>> findInfoCompaniesByCompanyName(InfoCompanyVo infoCompanyVo){
        return infoCompanyService.findInfoCompaniesByCompanyName(infoCompanyVo.getCompanyName());
    }
}
