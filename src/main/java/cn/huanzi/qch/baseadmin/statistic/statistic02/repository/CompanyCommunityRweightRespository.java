package cn.huanzi.qch.baseadmin.statistic.statistic02.repository;

import cn.huanzi.qch.baseadmin.common.repository.CommonRepository;
import cn.huanzi.qch.baseadmin.statistic.statistic02.pojo.CompanyCommunityRweight;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyCommunityRweightRespository extends CommonRepository<CompanyCommunityRweight, String> {
    List<CompanyCommunityRweight> findCompanyCommunityRweightsByCompanyName(String companyName);

}
