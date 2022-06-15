package cn.huanzi.qch.baseadmin.info.infocompany.repository;

import cn.huanzi.qch.baseadmin.common.repository.CommonRepository;
import cn.huanzi.qch.baseadmin.info.infocompany.pojo.InfoCompany;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoCompanyRepository extends CommonRepository<InfoCompany, String> {
    List<InfoCompany> findInfoCompaniesByCompanyName(String companyName);
}
