package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class EncodingController {

    @PostMapping("/e/t1")
    public String test1(String name, Model model, HttpServletRequest request) throws UnsupportedEncodingException {

        request.setCharacterEncoding("utf-8");
        System.out.println(name);
        model.addAttribute("msg",name);//获取表单提交的值

        return "test";//跳转到test页面显示输入的值
    }
}
