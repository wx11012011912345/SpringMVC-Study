package com.kuang.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/HelloController")
public class HelloController {
    //真实访问地址 : 项目名/HelloController/hello
    @RequestMapping("/hello")
    public String sayHello(Model model){
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg","hello,SpringMVC-Annotation");
        //web-inf/jsp/hello.jsp
        return "hello";//返回的字符串会被视图解析器处理，跳转到字符串值指定的视图
    }
}//浏览器输入：http://localhost:8080/SpringMVC_03_HelloSpringMVC_Annotation//HelloController/hello