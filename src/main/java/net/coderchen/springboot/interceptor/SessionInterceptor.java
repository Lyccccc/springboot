package net.coderchen.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Liuyuchen
 * @Date 2018/11/29
 * @Description 登录状态拦截器
 */
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器 - " + request.getRequestURI());
        //不拦截登录
        if("/loginView".equals(request.getRequestURI())
                || "/login/check".equals(request.getRequestURI())){
            return true;
        }
        Object obj = request.getSession().getAttribute("sessionUser");
        if(null == obj){
            response.sendRedirect("/loginView");
            return false;
        }
        //session中有值，已登录
        System.out.println("用户" + obj + "已登录");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
