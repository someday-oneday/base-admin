package cn.huanzi.qch.baseadmin.info.infohouse.service;

import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.common.service.CommonService;
import cn.huanzi.qch.baseadmin.info.infohouse.pojo.InfoHouse;
import cn.huanzi.qch.baseadmin.info.infohouse.vo.InfoHouseVo;

import java.util.List;

public interface InfoHouseService extends CommonService<InfoHouseVo, InfoHouse, String> {
    Result<List<InfoHouseVo>> findInfoHousesByHName(String hName);

    Result<InfoHouseVo> findInfoHouseByHId(String hid);
}
