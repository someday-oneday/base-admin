package cn.huanzi.qch.baseadmin.info.infosite.repository;

import cn.huanzi.qch.baseadmin.common.repository.CommonRepository;
import cn.huanzi.qch.baseadmin.info.infosite.pojo.InfoSite;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoSiteRepository extends CommonRepository<InfoSite, String> {
//    List<InfoSite> findInfoSitesBySiteGarbageId(String siteGarbageId);
}
