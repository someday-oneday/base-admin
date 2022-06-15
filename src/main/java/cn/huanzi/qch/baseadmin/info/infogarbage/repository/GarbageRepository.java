package cn.huanzi.qch.baseadmin.info.infogarbage.repository;

import cn.huanzi.qch.baseadmin.common.repository.CommonRepository;
import cn.huanzi.qch.baseadmin.info.infogarbage.pojo.Garbage;
import org.springframework.stereotype.Repository;

@Repository
public interface GarbageRepository extends CommonRepository<Garbage, String> {
    Garbage findGarbageByGName(String gName);
    Garbage findGarbageByGId(String gId);

}
