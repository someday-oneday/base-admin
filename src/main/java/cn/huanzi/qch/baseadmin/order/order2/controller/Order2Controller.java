package cn.huanzi.qch.baseadmin.order.order2.controller;

import cn.huanzi.qch.baseadmin.annotation.Decrypt;
import cn.huanzi.qch.baseadmin.annotation.Encrypt;
import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.order.order2.pojo.Order2;
import cn.huanzi.qch.baseadmin.order.order2.service.Order2Service;
import cn.huanzi.qch.baseadmin.order.order2.vo.Order2Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/order/order2/")
public class Order2Controller extends CommonController<Order2Vo, Order2, String> {
    @Autowired
    private Order2Service order2Service;

    @PostMapping("saveOrder2")
    @Decrypt
    @Encrypt
    public Result<Order2Vo> saveOrder(Order2Vo order2Vo) {
        order2Vo.setState("未接收");
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order2Vo.setOrdertime(df.format(day));
        return order2Service.save(order2Vo);
    }

    @GetMapping("order2")
    public ModelAndView order2(){
        return new ModelAndView("order2/order");
    }


}
