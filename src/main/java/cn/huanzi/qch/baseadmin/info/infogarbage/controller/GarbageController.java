package cn.huanzi.qch.baseadmin.info.infogarbage.controller;

import cn.huanzi.qch.baseadmin.annotation.Decrypt;
import cn.huanzi.qch.baseadmin.annotation.Encrypt;
import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.info.infogarbage.pojo.Garbage;
import cn.huanzi.qch.baseadmin.info.infogarbage.service.GarbageService;
import cn.huanzi.qch.baseadmin.info.infogarbage.vo.GarbageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/info/infogarbage/")
public class GarbageController extends CommonController<GarbageVo, Garbage, String> {
    @Autowired
    private GarbageService garbageService;

    @GetMapping("garbagelist")
    public ModelAndView garbagelist(){
        return new ModelAndView("info/garbage");
    }

    @PostMapping("receivegarbage")
    @Decrypt
    @Encrypt
    public Result<GarbageVo> findGarbageByGName(GarbageVo infoGarbageVo){
        return garbageService.findGarbageByGName(infoGarbageVo.getGName());
    }

    @PostMapping("receivegarbage2")
    @Decrypt
    @Encrypt
    public Result<GarbageVo> findGarbageByGId(GarbageVo infoGarbageVo){
        return garbageService.findGarbageByGId(infoGarbageVo.getGId());
    }
}
