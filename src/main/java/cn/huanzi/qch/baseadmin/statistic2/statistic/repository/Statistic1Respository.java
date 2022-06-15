package cn.huanzi.qch.baseadmin.statistic2.statistic.repository;

import cn.huanzi.qch.baseadmin.common.repository.CommonRepository;
import cn.huanzi.qch.baseadmin.statistic2.statistic.pojo.Statistic1;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Statistic1Respository extends CommonRepository<Statistic1, String> {
    List<Statistic1> findStatistic1sByCompanyId(String companyId);

}
