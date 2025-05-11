package com.example.apringmvcbestpractice.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyHandlerInterceptor1 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyHandlerInterceptor1.preHandle方法执行........");
        /*
        * 在前置逻辑中可以添加校验等逻辑。比如：如果用户名不是admin提示无权限，实现如下：
                String username = request.getParameter("username");
                response.getWriter().write("No Permission!");   //检查时失败时直接返回请求
                return false;
        * */
//        return false;    //return true表示不拦截这个请求，后面的逻辑继续
        return true;
    }

    /**
     * postHandle是controller方法执行之后
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyHandlerInterceptor1.postHandle方法执行........");
//        int i = 10/0;
    }

    /**
     * 拦截器的preHandle返回true时，该拦截器的afterCompletion 方法才会执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyHandlerInterceptor1.afterCompletion方法执行........");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
