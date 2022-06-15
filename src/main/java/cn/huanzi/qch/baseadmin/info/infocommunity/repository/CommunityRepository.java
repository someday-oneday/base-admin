package cn.huanzi.qch.baseadmin.info.infocommunity.repository;

import cn.huanzi.qch.baseadmin.common.repository.CommonRepository;
import cn.huanzi.qch.baseadmin.info.infocommunity.pojo.Community;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityRepository extends CommonRepository<Community, String> {
    List<Community> findCommunitiesByComName(String comName);
}
