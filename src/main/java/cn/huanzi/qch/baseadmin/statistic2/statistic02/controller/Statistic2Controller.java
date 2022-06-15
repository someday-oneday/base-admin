package cn.huanzi.qch.baseadmin.statistic2.statistic02.controller;

import cn.huanzi.qch.baseadmin.annotation.Decrypt;
import cn.huanzi.qch.baseadmin.annotation.Encrypt;
import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.statistic2.statistic02.pojo.Statistic2;
import cn.huanzi.qch.baseadmin.statistic2.statistic02.repository.Statistic2Respository;
import cn.huanzi.qch.baseadmin.statistic2.statistic02.service.Statistic2Service;
import cn.huanzi.qch.baseadmin.statistic2.statistic02.vo.Statistic2Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companycommunityrweight2/companycommunityrweight2/")
public class Statistic2Controller extends CommonController<Statistic2Vo, Statistic2, String> {
    @Autowired
    private Statistic2Service statistic2Service;

    @PostMapping("findCompanyCommunityRweight2ByCompanyId")
    @Decrypt
    @Encrypt
    public Result<List<Statistic2Vo>> findStatistic2sByCompanyId(Statistic2Vo statistic2Vo){
        return statistic2Service.findStatistic2sByCompanyId(statistic2Vo.getCompanyId());
    }

    }

