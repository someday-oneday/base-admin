package cn.huanzi.qch.baseadmin.order.order2sysusergarbagehousecompany.controller;

import cn.huanzi.qch.baseadmin.annotation.Decrypt;
import cn.huanzi.qch.baseadmin.annotation.Encrypt;
import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.order.order2sysusergarbagehousecompany.pojo.Order2SysUserGarbageHouseCompany;
import cn.huanzi.qch.baseadmin.order.order2sysusergarbagehousecompany.service.Order2SysUserGarbageHouseCompanyService;
import cn.huanzi.qch.baseadmin.order.order2sysusergarbagehousecompany.vo.Order2SysUserGarbageHouseCompanyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/order/order22/")
public class Order2SysUserGarbageHouseCompanyController extends CommonController<Order2SysUserGarbageHouseCompanyVo, Order2SysUserGarbageHouseCompany, String> {
    @Autowired
    private Order2SysUserGarbageHouseCompanyService order2SysUserGarbageHouseCompanyService;


    @GetMapping("myorder2")
    public ModelAndView myorder2(){

        return new ModelAndView("order2/myorder");
    }

    @GetMapping("ordersManage")
    public ModelAndView ordersManage(){

        return new ModelAndView("order2/ordersManage");
    }

//    @GetMapping("callback")
//    public ModelAndView callback(){
//
//        return new ModelAndView("map/callback");
//    }

    @GetMapping("cararrange")
    public ModelAndView cararrange(){

        return new ModelAndView("car/cararrange");
    }

    @GetMapping("userCallback")
    public ModelAndView userCallback(){

        return new ModelAndView("map/userCallback");
    }

    @GetMapping("callback")
    public ModelAndView callback(){

        return new ModelAndView("map/callback");
    }

    @GetMapping("map")
    public ModelAndView map(){

        return new ModelAndView("map/map");
    }

    @GetMapping("map1")
    public ModelAndView map1(){

        return new ModelAndView("map/map1");
    }

    @GetMapping("map2")
    public ModelAndView map2(){

        return new ModelAndView("map/map2");
    }

    @PostMapping("findOrder2SysUserGarbageHouseCompanyByCompanyIdAndGotime")
    @Decrypt
    @Encrypt
    public Result<List<Order2SysUserGarbageHouseCompanyVo>> findOrder2SysUserGarbageHouseCompanyByCompanyIdAndGotime(Order2SysUserGarbageHouseCompanyVo order2SysUserGarbageHouseCompanyVo) {
return order2SysUserGarbageHouseCompanyService.findOrder2SysUserGarbageHouseCompanyByCompanyIdAndGotime(order2SysUserGarbageHouseCompanyVo.getCompanyId(),order2SysUserGarbageHouseCompanyVo.getGotime());    }

//
//    @PostMapping("findOrder2SysUserGarbageHouseCompanyByCompanyIdAndGotimeAndgAndGotimes")
//    @Decrypt
//    @Encrypt
//    public Result<List<Order2SysUserGarbageHouseCompanyVo>> findOrder2SysUserGarbageHouseCompanyByCompanyIdAndGotimeAndgAndGotimes(Order2SysUserGarbageHouseCompanyVo order2SysUserGarbageHouseCompanyVo) {
//        return order2SysUserGarbageHouseCompanyService.findOrder2SysUserGarbageHouseCompanyByCompanyIdAndGotimeAndgAndGotimes(order2SysUserGarbageHouseCompanyVo.getCompanyId(),order2SysUserGarbageHouseCompanyVo.getGotime(),order2SysUserGarbageHouseCompanyVo.getGotimes());    }

//    @PostMapping("saveOrder2")
//    @Decrypt
//    @Encrypt
//    public Result<Order2SysUserGarbageHouseCompanyVo> saveOrder(Order2SysUserGarbageHouseCompanyVo order2Vo) {
//        order2Vo.setState("未接收");
//        order2Vo.setLate("按时");
//        Date day = new Date();
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        order2Vo.setOrdertime(df.format(day));
//        return order2Service.save(order2Vo);
//    }

//    @PostMapping("findOrdersByCompanyNameAndStateAndGotime")
//    @Decrypt
//    @Encrypt
//    public Result<List<Order2Vo>> findOrdersByCompanyNameAndStateAndGotime(Order2Vo orderVo) {
//return orderService.findOrdersByCompanyNameAndStateAndGotime(orderVo.getCompanyName(),orderVo.getState(),orderVo.getGotime());    }

//    @GetMapping("order2")
//    public ModelAndView order2(){
//        return new ModelAndView("order2/order");
//    }

    @GetMapping("allorders2")
    public ModelAndView findAllOrders(){
        return new ModelAndView("order2/allorders");
    }

    @GetMapping("orderreceive2")
    public ModelAndView receiveOrder(){
        return new ModelAndView("order2/orderreceive");
    }

    @GetMapping("successorder2")
    public ModelAndView successorder2(){
        return new ModelAndView("order2/successorder");
    }

    @GetMapping("statistic2")
    public ModelAndView statistic2(){
        return new ModelAndView("statistic/statistic2");
    }

}
