package cn.huanzi.qch.baseadmin.statistic2.statistic02.service;

import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.common.service.CommonService;
import cn.huanzi.qch.baseadmin.statistic2.statistic02.pojo.Statistic2;
import cn.huanzi.qch.baseadmin.statistic2.statistic02.vo.Statistic2Vo;

import java.util.List;

public interface Statistic2Service extends CommonService<Statistic2Vo, Statistic2, String> {
    Result<List<Statistic2Vo>> findStatistic2sByCompanyId(String companyId);
}
