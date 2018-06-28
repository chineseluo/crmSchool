package com.student.crm.util;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/9/28.
 */
@ControllerAdvice
public class ExceptionHanlder {

    // 定义的是当前需要去处理的异常
    @ExceptionHandler(UnauthorizedException.class)
    public void handlerException(HandlerMethod handlerMethod, HttpServletResponse response) {
        try {
            // 分开类处理页面和ajax的请求
            // 判断当前的请求的controller是否被responseBody贴着
            // 先要拿到handlerMethod 也就是当前的请求的controller方法
            if (handlerMethod.getMethodAnnotation(ResponseBody.class) != null) {
            /*处理ajax的请求  里面加载一个表单格式的数据*/
            /*由于 我们的列表的界面也是以个ajax 的   没有权限的话也会加载页面  这个时候没有total 和 rows 的话就会直接报错*/

                //  拿到response   设置编码的方式和传递数据
                response.setCharacterEncoding("utf-8");
                response.getWriter().print("{\"success\":false,\"msg\":\"你没有权限访问\",\"total\":0,\"rows\":[]}");
            } else {
                // 如果不是的话就直接返回一个没有权限的页面
                response.sendRedirect("/nopermission.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
