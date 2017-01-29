package com.company.filters;

import com.company.controllers.Constant;
import com.company.controllers.Page;
import com.company.entities.Member;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPageInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        Member member = (Member) request.getSession().getAttribute(Constant.MEMBER);
        if (member == null || member.getAccessType() == null) {
            return true;
        } else if (member.getAccessType().getTypeName().equals(Constant.ADMINISTRATOR)) {
            response.sendRedirect(Page.MAIN_ADMIN);
        }else if (member.getAccessType().getTypeName().equals(Constant.CUSTOMER)){
            response.sendRedirect(Page.MAIN_CUSTOMER);
        }else if (member.getAccessType().getTypeName().equals(Constant.EMPLOYEE)){
            if (member.getPosition().getPosName().equals(Constant.PROJECT_MANAGER)){
                response.sendRedirect(Page.MAIN_PROJECT_MANAGER);
            }
            response.sendRedirect(Page.MAIN_EMPLOYEE);
        }

        return false;
    }
}
