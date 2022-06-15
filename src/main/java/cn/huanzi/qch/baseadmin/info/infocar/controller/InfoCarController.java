package cn.huanzi.qch.baseadmin.info.infocar.controller;

import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.info.infocar.pojo.InfoCar;
import cn.huanzi.qch.baseadmin.info.infocar.service.InfoCarService;
import cn.huanzi.qch.baseadmin.info.infocar.vo.InfoCarVo;
import cn.huanzi.qch.baseadmin.sys.sysuser.pojo.SysUser;
import cn.huanzi.qch.baseadmin.sys.sysuser.vo.SysUserVo;
import cn.huanzi.qch.baseadmin.util.SysSettingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/info/infocar/")
public class InfoCarController extends CommonController<InfoCarVo, InfoCar, String> {
    @Autowired
    private InfoCarService infoCarService;


}
