package cn.huanzi.qch.baseadmin.info.infocar.service;

import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.common.service.CommonService;
import cn.huanzi.qch.baseadmin.info.infocar.pojo.InfoCar;
import cn.huanzi.qch.baseadmin.info.infocar.vo.InfoCarVo;

import java.util.List;

public interface InfoCarService extends CommonService<InfoCarVo, InfoCar, String> {
    Result<List<InfoCarVo>> findInfoCarsByCarName(String infoCarName);

}
