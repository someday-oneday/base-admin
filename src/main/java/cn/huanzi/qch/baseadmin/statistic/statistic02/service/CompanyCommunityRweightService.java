package cn.huanzi.qch.baseadmin.statistic.statistic02.service;

import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.common.service.CommonService;
import cn.huanzi.qch.baseadmin.statistic.statistic02.pojo.CompanyCommunityRweight;
import cn.huanzi.qch.baseadmin.statistic.statistic02.vo.CompanyCommunityRweightVo;

import java.util.List;

public interface CompanyCommunityRweightService extends CommonService<CompanyCommunityRweightVo, CompanyCommunityRweight, String> {
    Result<List<CompanyCommunityRweightVo>> findCompanyCommunityRweightsByCompanyName(String companyName);
}
