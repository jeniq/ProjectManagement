package com.company.filters;

import com.company.entities.Member;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPageInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        Member member = (Member) request.getSession().getAttribute("member");
        if (member == null || member.getAccessType() == null){
            return true;
        }else if (member.getAccessType().getTypeName().equals("Administrator")){
            response.sendRedirect("mainAdmin");
        }else{
            response.sendRedirect("main");
        }

        return false;
    }
}
