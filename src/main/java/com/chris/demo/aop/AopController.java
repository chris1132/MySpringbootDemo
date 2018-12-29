package com.chris.demo.aop;

import com.chris.demo.aop.aspect.TransactionAspectInterface;
import com.chris.demo.aop.service.DemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {

    @Autowired
    public DemoServiceImpl demoService;

    @RequestMapping(value = "/aoptest", method = RequestMethod.GET)
    @TransactionAspectInterface(desc = "这是事物拦截")
    public String aoptest() {
        return "aoptest";
    }


    @RequestMapping(value = "/testaop", method = RequestMethod.GET)
    @TransactionAspectInterface(desc = "这是事物拦截")
    public String testaop() {
        return "testaop";
    }
}
