package com.kuang.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {

    @RequestMapping("/t1")
    @ResponseBody
    public String test(){
        System.out.println("TestController==>test执行了");
        return "OK";
    }

    @RequestMapping("/interceptor")
    @ResponseBody
    public String testFunction() {
        System.out.println("控制器中的方法执行了");
        return "hello";
    }
}
