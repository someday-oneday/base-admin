package cn.huanzi.qch.baseadmin.info.infocommunity.controller;

import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.info.infocommunity.pojo.Community;
import cn.huanzi.qch.baseadmin.info.infocommunity.service.CommunityService;
import cn.huanzi.qch.baseadmin.info.infocommunity.vo.CommunityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/info/infocommunity/")
public class CommunityController extends CommonController<CommunityVo, Community, String> {
    @Autowired
    private CommunityService communityService;

    @GetMapping("communitylist")
    public ModelAndView communitylist(){
        return new ModelAndView("info/community");
    }
}
