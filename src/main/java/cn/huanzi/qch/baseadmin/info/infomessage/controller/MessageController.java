package cn.huanzi.qch.baseadmin.info.infomessage.controller;

import cn.huanzi.qch.baseadmin.annotation.Decrypt;
import cn.huanzi.qch.baseadmin.annotation.Encrypt;
import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.info.infomessage.pojo.Message;
import cn.huanzi.qch.baseadmin.info.infomessage.service.MessageService;
import cn.huanzi.qch.baseadmin.info.infomessage.vo.MessageVo;
import cn.huanzi.qch.baseadmin.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/info/infomessage/")
public class MessageController extends CommonController<MessageVo, Message, String> {
    @Autowired
    private MessageService messageService;

    @GetMapping("message")
    public ModelAndView newlist(){
        return new ModelAndView("message/message");
    }

    @GetMapping("messageManage")
    public ModelAndView messageManage(){
        return new ModelAndView("message/messageManage");
    }

    @PostMapping("saveMessage")
    @Decrypt
    @Encrypt
    public Result<MessageVo> saveMessage(MessageVo infoMessageVo) {
        infoMessageVo.setUserName(SecurityUtil.getLoginUser().getUsername());
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        infoMessageVo.setMTime(df.format(day));

        return messageService.save(infoMessageVo);
    }
}
