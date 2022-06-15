package cn.huanzi.qch.baseadmin.statistic.statistic.controller;

import cn.huanzi.qch.baseadmin.annotation.Decrypt;
import cn.huanzi.qch.baseadmin.annotation.Encrypt;
import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.statistic.statistic.pojo.CompanyGarbage;
import cn.huanzi.qch.baseadmin.statistic.statistic.repository.CompanyGarbageRespository;
import cn.huanzi.qch.baseadmin.statistic.statistic.service.CompanyGarbageService;
import cn.huanzi.qch.baseadmin.statistic.statistic.vo.CompanyGarbageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companygarbage/companygarbage/")
public class CompanyGarbageController extends CommonController<CompanyGarbageVo, CompanyGarbage, String> {
    @Autowired
    private CompanyGarbageService companyGarbageService;

    @Autowired
    private CompanyGarbageRespository companyGarbageRespository;

    @PostMapping("statistic")
    @Decrypt
    @Encrypt
    public Result<List<CompanyGarbageVo>> findCompanyGarbagesByCompanyName(CompanyGarbageVo companyGarbageVo){
    return companyGarbageService.findCompanyGarbagesByCompanyName(companyGarbageVo.getCompanyName());
    }
//    @GetMapping("orderhouse")
//    public ModelAndView orderhouse(){
//
//        return new ModelAndView("order/myorder");
//    }

    }

