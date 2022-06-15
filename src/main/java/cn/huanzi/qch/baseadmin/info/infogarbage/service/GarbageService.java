package cn.huanzi.qch.baseadmin.info.infogarbage.service;

import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.common.service.CommonService;
import cn.huanzi.qch.baseadmin.info.infogarbage.pojo.Garbage;
import cn.huanzi.qch.baseadmin.info.infogarbage.vo.GarbageVo;

public interface GarbageService extends CommonService<GarbageVo, Garbage, String> {
    Result<GarbageVo> findGarbageByGName(String gName);
Result<GarbageVo> findGarbageByGId(String gId);
}
