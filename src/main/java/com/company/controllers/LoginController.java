package com.company.controllers;

import com.company.entities.Member;
import com.company.services.impls.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * This class is Controller that contains servlets for work with authorization.
 */
@Controller
@SessionAttributes(Constant.MEMBER)
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView(Page.LOGIN, Constant.MEMBER, new Member());
    }

    @RequestMapping(value = "/check-member", method = RequestMethod.POST)
    public ModelAndView checkMember(@ModelAttribute(Constant.MEMBER) Member member) {
        ModelAndView modelAndView = new ModelAndView();
        member = authenticationService.login(member);

        if (member == null) {
            modelAndView.setViewName(Page.REDIRECT_AUTH_FAILED);
            return modelAndView;
        }

        modelAndView.addObject(Constant.MEMBER, member);

        switch (member.getAccessType().getTypeName()) {
            case Constant.ADMINISTRATOR:
                modelAndView.setViewName(Page.REDIRECT_ADMINISTRATOR);
                break;
            case Constant.EMPLOYEE:
                modelAndView.setViewName(Page.REDIRECT_EMPLOYEE);
                break;
            case Constant.CUSTOMER:
                modelAndView.setViewName(Page.REDIRECT_CUSTOMER);
                break;
            default:
                modelAndView.setViewName(Page.REDIRECT_AUTH_FAILED);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/failed", method = RequestMethod.GET)
    public ModelAndView failed() {
        return new ModelAndView(Page.LOGIN, Constant.MESSAGE, Constant.WRONG_AUTH_DATA);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(SessionStatus session) {
        session.setComplete();
        return Page.REDIRECT_LOGIN;
    }

}
