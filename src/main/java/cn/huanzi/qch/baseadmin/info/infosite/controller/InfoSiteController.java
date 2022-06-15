package cn.huanzi.qch.baseadmin.info.infosite.controller;

import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.info.infosite.pojo.InfoSite;
import cn.huanzi.qch.baseadmin.info.infosite.service.InfoSiteService;
import cn.huanzi.qch.baseadmin.info.infosite.vo.InfoSiteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/info/infosite/")
public class InfoSiteController extends CommonController<InfoSiteVo, InfoSite, String> {
    @Autowired
    private InfoSiteService infoSiteService;

    @GetMapping("sitelist")
    public ModelAndView sitelist(){
        return new ModelAndView("info/site");
    }



}
