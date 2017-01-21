package com.company.controllers;

import com.company.entities.Member;
import com.company.services.impls.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("member")
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView("login", "member", new Member());
    }

    @RequestMapping(value = "/check-member", method = RequestMethod.POST)
    public ModelAndView checkMember(@ModelAttribute("member") Member member) {
        ModelAndView modelAndView = new ModelAndView();
        member = authenticationService.login(member);

        if (member == null){
            modelAndView.setViewName("redirect:/failed");
            return modelAndView;
        }

        modelAndView.addObject("member", member);

        if (member.getAccessType().getTypeName().equals("Administrator")){
            modelAndView.setViewName("redirect:mainAdmin");
        }else{
            modelAndView.setViewName("redirect:main");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/failed", method = RequestMethod.GET)
    public ModelAndView failed(){
        return new ModelAndView("login", "message", "Incorrect login/password");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(SessionStatus session){
        session.setComplete();
        return "redirect:/";
    }

}
