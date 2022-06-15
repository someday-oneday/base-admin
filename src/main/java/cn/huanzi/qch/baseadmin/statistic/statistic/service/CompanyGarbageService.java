package cn.huanzi.qch.baseadmin.statistic.statistic.service;

import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.common.service.CommonService;
import cn.huanzi.qch.baseadmin.statistic.statistic.pojo.CompanyGarbage;
import cn.huanzi.qch.baseadmin.statistic.statistic.vo.CompanyGarbageVo;

import java.util.List;

public interface CompanyGarbageService extends CommonService<CompanyGarbageVo, CompanyGarbage, String> {
    Result<List<CompanyGarbageVo>> findCompanyGarbagesByCompanyName(String companyName);
}
