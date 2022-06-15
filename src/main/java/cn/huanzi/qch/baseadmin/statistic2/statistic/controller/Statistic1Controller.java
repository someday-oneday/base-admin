package cn.huanzi.qch.baseadmin.statistic2.statistic.controller;

import cn.huanzi.qch.baseadmin.annotation.Decrypt;
import cn.huanzi.qch.baseadmin.annotation.Encrypt;
import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.statistic2.statistic.pojo.Statistic1;
import cn.huanzi.qch.baseadmin.statistic2.statistic.repository.Statistic1Respository;
import cn.huanzi.qch.baseadmin.statistic2.statistic.service.Statistic1Service;
import cn.huanzi.qch.baseadmin.statistic2.statistic.vo.Statistic1Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companygarbage2/companygarbage2/")
public class Statistic1Controller extends CommonController<Statistic1Vo, Statistic1, String> {
    @Autowired
    private Statistic1Service statistic1Service;

    @PostMapping("statistic2")
    @Decrypt
    @Encrypt
    public Result<List<Statistic1Vo>> findStatistic1sByCompanyId(Statistic1Vo statistic1Vo){
    return statistic1Service.findStatistic1sByCompanyId(statistic1Vo.getCompanyId());
    }

    }

