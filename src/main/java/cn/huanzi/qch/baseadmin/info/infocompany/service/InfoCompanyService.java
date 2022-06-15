package cn.huanzi.qch.baseadmin.info.infocompany.service;

import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.common.service.CommonService;
import cn.huanzi.qch.baseadmin.info.infocompany.pojo.InfoCompany;
import cn.huanzi.qch.baseadmin.info.infocompany.vo.InfoCompanyVo;

import java.util.List;

public interface InfoCompanyService extends CommonService<InfoCompanyVo, InfoCompany, String> {
    Result<List<InfoCompanyVo>> findInfoCompaniesByCompanyName(String companyName);

}
