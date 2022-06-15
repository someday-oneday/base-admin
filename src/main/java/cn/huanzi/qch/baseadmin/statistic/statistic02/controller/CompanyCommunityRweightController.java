package cn.huanzi.qch.baseadmin.statistic.statistic02.controller;

import cn.huanzi.qch.baseadmin.annotation.Decrypt;
import cn.huanzi.qch.baseadmin.annotation.Encrypt;
import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.statistic.statistic02.pojo.CompanyCommunityRweight;
import cn.huanzi.qch.baseadmin.statistic.statistic02.repository.CompanyCommunityRweightRespository;
import cn.huanzi.qch.baseadmin.statistic.statistic02.service.CompanyCommunityRweightService;
import cn.huanzi.qch.baseadmin.statistic.statistic02.vo.CompanyCommunityRweightVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companycommunityrweight/companycommunityrweight/")
public class CompanyCommunityRweightController extends CommonController<CompanyCommunityRweightVo, CompanyCommunityRweight, String> {
    @Autowired
    private CompanyCommunityRweightService companyCommunityRweightService;

    @Autowired
    private CompanyCommunityRweightRespository companyCommunityRweightRespository;

    @PostMapping("findCompanyCommunityRweightsByCompanyName")
    @Decrypt
    @Encrypt
    public Result<List<CompanyCommunityRweightVo>> findCompanyCommunityRweightsByCompanyName(CompanyCommunityRweightVo companyCommunityRweightVo){
        return companyCommunityRweightService.findCompanyCommunityRweightsByCompanyName(companyCommunityRweightVo.getCompanyName());
    }
//    @GetMapping("orderhouse")
//    public ModelAndView orderhouse(){
//
//        return new ModelAndView("order/myorder");
//    }

    }

