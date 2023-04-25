package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    //http://localhost:8080/SpringMVC_04_Controller/user/t1?name=xxx
    @GetMapping("/t1")
    //接收的前端参数名必须为username，不能为其它名字，如name1、name2...
    public String test1(String name, Model model){//获取前端参数name，通过model发送数据给要跳转的视图
        //1.接收前端参数
        System.out.println("接收到的前端参数为："+name);

        //2.将返回的结果通过model传递给前端
        model.addAttribute("msg",name);

        //3.试图跳转
        return "test";
    }

    //http://localhost:8080/SpringMVC_04_Controller/user/t2?username=xxx
    @GetMapping("/t2")
    //接收的前端参数名必须为name，不能为其它名字，如name1、username...
    public String test2(@RequestParam("username") String name, Model model){//获取前端参数name，通过model发送数据给要跳转的视图
        //1.接收前端参数
        System.out.println("接收到的前端参数为："+name);

        //2.将返回的结果通过model传递给前端
        model.addAttribute("msg",name);

        //3.视图跳转
        return "test";
    }


    //从前端接收的是一个对象User{id,name,age}
    /*
    1.接收前端用户传递的参数，判断参数的名字，假设名字直接在方法上，可以直接使用
    2.假设传递的是一个对象的User，匹配User中的字段名，如果名字一致则OK，否则匹配不到
     */
    @GetMapping("t3")
    public String test3(User user){

        System.out.println(user);


        return "test";
    }

    @RequestMapping("/user")
    public String hello(@RequestParam("username") String name, ModelMap model){
        //封装要显示到视图中的数据
        //相当于req.setAttribute("name",name);
        model.addAttribute("name",name);
        System.out.println(name);
        return "hello";
    }

}
