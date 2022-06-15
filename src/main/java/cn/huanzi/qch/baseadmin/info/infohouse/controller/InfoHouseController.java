package cn.huanzi.qch.baseadmin.info.infohouse.controller;

import cn.huanzi.qch.baseadmin.annotation.Decrypt;
import cn.huanzi.qch.baseadmin.annotation.Encrypt;
import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.info.infohouse.pojo.InfoHouse;
import cn.huanzi.qch.baseadmin.info.infohouse.service.InfoHouseService;
import cn.huanzi.qch.baseadmin.info.infohouse.vo.InfoHouseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/info/infohouse/")
public class InfoHouseController extends CommonController<InfoHouseVo, InfoHouse, String> {
    @Autowired
    private InfoHouseService infoHouseService;

    @GetMapping("houselist")
    public ModelAndView houselist(){
        return new ModelAndView("info/house");
    }

    @PostMapping("findInfoHouseByHId")
    @Decrypt
    @Encrypt
    public Result<InfoHouseVo> findInfoHouseByHId(InfoHouseVo infoHouseVo) {
        return infoHouseService.findInfoHouseByHId(infoHouseVo.getHId());   }

}
