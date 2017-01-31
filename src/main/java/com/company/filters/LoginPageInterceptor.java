package com.company.filters;

import com.company.controllers.Constant;
import com.company.controllers.Page;
import com.company.entities.Member;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class-interceptor returns authorized user to his main page instead opening login page.
 */
public class LoginPageInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        Member member = (Member) request.getSession().getAttribute(Constant.MEMBER);
        if (member == null || member.getAccessType() == null) {
            return true;
        } else if (member.getAccessType().getTypeName().equals(Constant.ADMINISTRATOR)) {
            response.sendRedirect(Page.ADMIN);
        } else if (member.getAccessType().getTypeName().equals(Constant.CUSTOMER)) {
            response.sendRedirect(Page.CUSTOMER);
        } else if (member.getAccessType().getTypeName().equals(Constant.EMPLOYEE)) {
            if (member.getPosition().getPosName().equals(Constant.PROJECT_MANAGER)) {
                request.getRequestDispatcher(
                        Page.PROJECT_MANAGER).forward(request, response); // works with dispatcher only
            }
            response.sendRedirect(Page.EMPLOYEE);
        }

        return false;
    }
}
