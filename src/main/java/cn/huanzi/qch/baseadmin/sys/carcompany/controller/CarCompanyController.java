package cn.huanzi.qch.baseadmin.sys.carcompany.controller;

import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.sys.carcompany.pojo.CarCompany;
import cn.huanzi.qch.baseadmin.sys.carcompany.service.CarCompanyService;
import cn.huanzi.qch.baseadmin.sys.carcompany.vo.CarCompanyVo;
import cn.huanzi.qch.baseadmin.sys.sysauthority.pojo.SysAuthority;
import cn.huanzi.qch.baseadmin.sys.sysauthority.service.SysAuthorityService;
import cn.huanzi.qch.baseadmin.sys.sysauthority.vo.SysAuthorityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/sys/carCompany/")
public class CarCompanyController extends CommonController<CarCompanyVo, CarCompany, String> {
    @Autowired
    private CarCompanyService carCompanyService;

    @GetMapping("carCompany")
    public ModelAndView authority(){
        return new ModelAndView("info/car");
    }

}
