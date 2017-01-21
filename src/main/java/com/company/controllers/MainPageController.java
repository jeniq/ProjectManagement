package com.company.controllers;

import com.company.entities.Member;
import com.company.entities.Project;
import com.company.services.impls.MemberService;
import com.company.services.impls.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes("member")
public class MainPageController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/mainAdmin", method = RequestMethod.GET)
    public ModelAndView projectList(@ModelAttribute("member") Member member){
        ModelAndView modelAndView = new ModelAndView();
        List<Project> projectList = projectService.getProjectList(member);
        List<Member> memberList = memberService.getMemberList();

        modelAndView.addObject("projectList", projectList);
        modelAndView.addObject("memberList", memberList);
        modelAndView.setViewName("mainAdmin");
        return modelAndView;
    }



}
