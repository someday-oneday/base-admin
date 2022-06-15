package cn.huanzi.qch.baseadmin.statistic.statistic.repository;

import cn.huanzi.qch.baseadmin.common.repository.CommonRepository;
import cn.huanzi.qch.baseadmin.statistic.statistic.pojo.CompanyGarbage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyGarbageRespository extends CommonRepository<CompanyGarbage, String> {
    List<CompanyGarbage> findCompanyGarbagesByCompanyName(String companyName);

}
