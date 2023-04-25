package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestFulController {

    // 以前的风格： http://localhost:8080/SpringMVC_04_Controller/commit?p1=3&p2=7
    @RequestMapping("/commit")//p1,p1可以直接从前端获取参数
    public String test0(int p1, int p2, Model model){
        int result = p1+p2;
        //Spring MVC会自动实例化一个Model对象用于向视图中传值
        model.addAttribute("msg", "结果："+result);
        //返回视图位置
        return "test";
    }

    // restful风格： http://localhost:8080/SpringMVC_04_Controller/commit/3/7
    @RequestMapping("/commit/{p1}/{p2}")//p1,p1可以直接从前端获取参数
    public String test1(@PathVariable int p1, @PathVariable int p2, Model model){
        int result = p1+p2;
        //Spring MVC会自动实例化一个Model对象用于向视图中传值
        model.addAttribute("msg", "结果："+result);
        //返回视图位置
        return "test";
    }

    // restful风格： http://localhost:8080/SpringMVC_04_Controller/commit/3/a
//    @RequestMapping("/commit/{p1}/{p2}")//p1,p1可以直接从前端获取参数
//    public String test1(@PathVariable int p1, @PathVariable String p2, Model model){
//        String result = p1+p2;
//        //Spring MVC会自动实例化一个Model对象用于向视图中传值
//        model.addAttribute("msg", "结果："+result);
//        //返回视图位置
//        return "test";
//    }


    // restful风格： http://localhost:8080/SpringMVC_04_Controller/commit/3/7
    @RequestMapping(value="/commit/{p1}/{p2}",method= RequestMethod.POST)//p1,p1可以直接从前端获取参数
    public String test2(@PathVariable int p1, @PathVariable int p2, Model model){
        int result = p1+p2;
        //Spring MVC会自动实例化一个Model对象用于向视图中传值
        model.addAttribute("msg", "结果："+result);
        //返回视图位置
        return "test";
    }

    //映射访问路径,必须是POST请求
    @RequestMapping(value = "/hello",method = {RequestMethod.GET})
    public String index2(Model model){
        model.addAttribute("msg", "hello!");
        return "test";
    }

}
