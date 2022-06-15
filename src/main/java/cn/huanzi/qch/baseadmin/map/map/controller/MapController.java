package cn.huanzi.qch.baseadmin.map.map.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/map/map/")
public class MapController {
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
    @GetMapping("testSite")
    public ModelAndView testSite(){

        return new ModelAndView("map/testSite");
    }

}
