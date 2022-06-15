package cn.huanzi.qch.baseadmin.info.infocommunity.service;

import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.common.service.CommonService;
import cn.huanzi.qch.baseadmin.info.infocommunity.pojo.Community;
import cn.huanzi.qch.baseadmin.info.infocommunity.vo.CommunityVo;

import java.util.List;

public interface CommunityService extends CommonService<CommunityVo, Community, String> {
    Result<List<CommunityVo>> findCommunitiesByComName(String comName);
}
