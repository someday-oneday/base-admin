package cn.huanzi.qch.baseadmin.statistic2.statistic02.repository;

import cn.huanzi.qch.baseadmin.common.repository.CommonRepository;
import cn.huanzi.qch.baseadmin.statistic2.statistic02.pojo.Statistic2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Statistic2Respository extends CommonRepository<Statistic2, String> {
    List<Statistic2> findStatistic2sByCompanyId(String companyId);

}
