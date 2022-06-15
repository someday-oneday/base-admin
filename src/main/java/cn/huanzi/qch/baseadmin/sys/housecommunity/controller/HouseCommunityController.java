package cn.huanzi.qch.baseadmin.sys.housecommunity.controller;

import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.sys.housecommunity.pojo.HouseCommunity;
import cn.huanzi.qch.baseadmin.sys.housecommunity.service.HouseCommunityService;
import cn.huanzi.qch.baseadmin.sys.housecommunity.vo.HouseCommunityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/sys/houseCommunity/")
public class HouseCommunityController extends CommonController<HouseCommunityVo, HouseCommunity, String> {
    @Autowired
    private HouseCommunityService houseCommunityService;

    @GetMapping("houseCommunity")
    public ModelAndView authority(){
        return new ModelAndView("info/house");
    }

}
