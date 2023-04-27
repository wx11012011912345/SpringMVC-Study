package com.kuang.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 29501
 */
public class MyInterceptor implements HandlerInterceptor {
    //Servlet和Filter接口要求必须重写其所有方法
    // HandlerInterceptor接口不会强制要求重写它的所有方法

    /**
     * 在请求处理的方法之前执行
     * return ture：放行，执行下一个拦截器
     * return false：被拦截，不执行下一个拦截器
     **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("=========处理前=========");
        return true;
    }

    //在请求处理方法执行之后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("=========处理后=========");
    }

    //在dispatcherServlet处理后执行,做清理工作.
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("=========清理=========");
    }
}
