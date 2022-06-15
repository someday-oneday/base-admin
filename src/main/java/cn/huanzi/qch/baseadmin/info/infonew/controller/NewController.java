package cn.huanzi.qch.baseadmin.info.infonew.controller;

import cn.huanzi.qch.baseadmin.annotation.Decrypt;
import cn.huanzi.qch.baseadmin.annotation.Encrypt;
import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.info.infonew.pojo.New;
import cn.huanzi.qch.baseadmin.info.infonew.service.NewService;
import cn.huanzi.qch.baseadmin.info.infonew.vo.NewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/info/infonews/")
public class NewController extends CommonController<NewVo, New, String> {
    @Autowired
    private NewService newService;

    @GetMapping("news")
    public ModelAndView newlist(){
        return new ModelAndView("new/news");
    }

    @GetMapping("newManage")
    public ModelAndView newManage(){
        return new ModelAndView("new/newManage");
    }

    @GetMapping("publish")
    public ModelAndView publishnews(){
        return new ModelAndView("new/publishnews");
    }

    @PostMapping("saveNew")
    @Decrypt
    @Encrypt
    public Result<NewVo> saveNew(NewVo newVo) {
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        newVo.setNewTime(df.format(day));

        return newService.save(newVo);
    }
}
