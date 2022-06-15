package cn.huanzi.qch.baseadmin.sys.sitegarbage.controller;

import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.sys.sitegarbage.pojo.SiteGarbage;
import cn.huanzi.qch.baseadmin.sys.sitegarbage.service.SiteGarbageService;
import cn.huanzi.qch.baseadmin.sys.sitegarbage.vo.SiteGarbageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/sys/siteGarbage/")
public class SiteGarbageController extends CommonController<SiteGarbageVo, SiteGarbage, String> {
    @Autowired
    private SiteGarbageService houseCommunityService;

    @GetMapping("sitegarbage")
    public ModelAndView authority(){
        return new ModelAndView("info/site");
    }

}
