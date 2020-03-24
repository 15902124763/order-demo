package com.yarm.controller;

import com.yarm.service.OrderService;
import com.yarm.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @Author : yarm.yang
 * @Date : 2020/3/24 13:44
*/
@RestController
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ThreadService threadService;

    /**
     * @Description :入口
     * @Author : yarm.yang
     * @Date : 2020/3/24 13:45
     * @Return :
    */
    @RequestMapping("test")
    public String test(){
        orderService.insert();
        return "ok";
    }

    @RequestMapping("run")
    public String run(){
        threadService.future();
        return "ok";
    }
}
