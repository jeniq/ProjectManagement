package com.company.controllers;

import com.company.entities.Member;
import com.company.entities.Project;
import com.company.services.impls.MemberService;
import com.company.services.impls.ProjectService;
import com.company.services.impls.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@SessionAttributes(Constant.MEMBER)
public class MainPageController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView projectList(@ModelAttribute(Constant.MEMBER) Member member) {

        ModelAndView modelAndView = new ModelAndView();
        List<Project> projectList = projectService.getProjectList(member);
        List<Member> memberList = memberService.getMemberList();

        modelAndView.addObject(Constant.PROJECT_LIST, projectList);
        modelAndView.addObject(Constant.MEMBER_LIST, memberList);

        modelAndView.setViewName(Page.MAIN_ADMIN);
        return modelAndView;
    }

    @RequestMapping(value = "/customer")
    public ModelAndView customerMainPage(@ModelAttribute(Constant.MEMBER) Member member) {
        ModelAndView modelAndView = new ModelAndView();
        List<Project> projectList = projectService.getProjectList(member);

        modelAndView.addObject(Constant.PROJECT_LIST, projectList);
        modelAndView.setViewName(Page.MAIN_CUSTOMER);

        return modelAndView;
    }

    @RequestMapping(value = "/employee")
    public String employeeMainPage(@ModelAttribute(Constant.MEMBER) Member member, HttpServletRequest request) {
        if (member.getPosition().getPosName().equals(Constant.PROJECT_MANAGER)) {
            return Page.REDIRECT_PROJECT_MANANGER;
        }

        request.setAttribute(Constant.TASK_LIST, taskService.getTaskByEmpId(member.getId()));

        return Page.MAIN_EMPLOYEE;
    }

    @RequestMapping(value = "/projectManager")
    public ModelAndView projectManagerMainPage(@ModelAttribute(Constant.MEMBER) Member member) {
        return new ModelAndView(Page.MAIN_PROJECT_MANAGER,
                Constant.PROJECT_LIST, projectService.getProjectList(member));
    }

}
