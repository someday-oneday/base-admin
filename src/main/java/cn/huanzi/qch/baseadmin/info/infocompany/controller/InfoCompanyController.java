package cn.huanzi.qch.baseadmin.info.infocompany.controller;

import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.info.infocompany.pojo.InfoCompany;
import cn.huanzi.qch.baseadmin.info.infocompany.service.InfoCompanyService;
import cn.huanzi.qch.baseadmin.info.infocompany.vo.InfoCompanyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/info/company1/")
public class InfoCompanyController extends CommonController<InfoCompanyVo, InfoCompany, String> {
    @Autowired
    private InfoCompanyService infoCompanyService;

    @GetMapping("companylists")
    public ModelAndView companylist(){
        return new ModelAndView("info/company");
    }
}
