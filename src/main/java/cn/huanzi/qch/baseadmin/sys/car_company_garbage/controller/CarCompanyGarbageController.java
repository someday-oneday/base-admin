package cn.huanzi.qch.baseadmin.sys.car_company_garbage.controller;

import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.sys.car_company_garbage.pojo.CarCompanyGarbage;
import cn.huanzi.qch.baseadmin.sys.car_company_garbage.service.CarCompanyGarbageService;
import cn.huanzi.qch.baseadmin.sys.car_company_garbage.vo.CarCompanyGarbageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/sys/carCompanyGarbage/")
public class CarCompanyGarbageController extends CommonController<CarCompanyGarbageVo, CarCompanyGarbage, String> {
    @Autowired
    private CarCompanyGarbageService carCompanyGarbageService;

    @GetMapping("carCompanyGarbage")
    public ModelAndView authority(){
        return new ModelAndView("info/car");
    }

    @GetMapping("carCompanyGarbage1")
    public ModelAndView authority1(){
        return new ModelAndView("info/companycar");
    }

}
