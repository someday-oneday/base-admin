package cn.huanzi.qch.baseadmin.statistic2.statistic.service;

import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.common.service.CommonService;
import cn.huanzi.qch.baseadmin.statistic2.statistic.pojo.Statistic1;
import cn.huanzi.qch.baseadmin.statistic2.statistic.vo.Statistic1Vo;

import java.util.List;

public interface Statistic1Service extends CommonService<Statistic1Vo, Statistic1, String> {
    Result<List<Statistic1Vo>> findStatistic1sByCompanyId(String companyId);
}
