package com.common.base.Interceptor;


import com.alibaba.fastjson.JSONObject;
import com.common.base.contants.Constants;
import com.web.entity.LoginUser;
import com.web.entity.User;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author crystalzhao
 * @version V1.0
 * @date 2018/10/29
 */
@Aspect
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private final String[] uris = {"/login","/regist"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*for(String uri : uris){
            if(request.getRequestURI().indexOf(uri) > 0){
                return true;
            }
        }

        HttpSession session = request.getSession();
        LoginUser user = (LoginUser) session.getAttribute(Constants.sessionId);
        if(user == null){
            JSONObject result = new JSONObject();
            result.put("code","-5");
            result.put("message","用户未登陆");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;
            try {
                out = response.getWriter();
                out.append(result.toString());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    out.close();
                }
            }
            return false;
        }*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println(33333);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println(44444);
    }
}
