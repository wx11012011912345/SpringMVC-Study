package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ModelTest1 {

    @RequestMapping("/m1/t1")
    public String test(HttpServletRequest request, HttpServletResponse response){
        HttpSession session=request.getSession();
        System.out.println(session.getId());
        return "test";
    }

    @RequestMapping("/m1/t2")
    public String test2(Model model){
        model.addAttribute("msg","ModelTest2");
        //转发
        return "test.jsp";//隐式声明为转发
//        return "forward:/WEB-INF/jsp/test.jsp";//显式声明为转发
    }

    @RequestMapping("/m1/t3")
    public String test3(Model model){
        model.addAttribute("msg","ModelTest3");
        //重定向
        return "redirect:/index.jsp";//隐式声明为转发
    }



}
