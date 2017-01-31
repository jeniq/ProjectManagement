package com.company.controllers;

import com.company.entities.Member;
import com.company.entities.Project;
import com.company.entities.Sprint;
import com.company.entities.Task;
import com.company.services.impls.MemberService;
import com.company.services.impls.ProjectService;
import com.company.services.impls.SprintService;
import com.company.services.impls.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * This class is Controller that contains servlets for work with Project.
 */
@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private SprintService sprintService;

    @Autowired
    private MemberService memberService;


    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/newProject", method = RequestMethod.GET)
    public ModelAndView newProject() {
        ModelAndView modelAndView = new ModelAndView();
        List<Member> projectManagerList = memberService.getProjectManagerList();
        List<Member> customerList = memberService.getCustomerList();

        modelAndView.addObject(Constant.CUSTOMER_LIST, customerList);
        modelAndView.addObject(Constant.PROJECT_MANAGER_LIST, projectManagerList);
        modelAndView.addObject(Constant.PROJECT, new Project());

        modelAndView.setViewName(Page.CREATE_PROJECT_POPUP);

        return modelAndView;
    }

    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public String addProject(@ModelAttribute(Constant.PROJECT) Project project, HttpServletRequest request) {
        Integer projectManagerId = Integer.parseInt(request.getParameter(Constant.PROJECT_MANAGER));
        Long customerId = Long.parseLong(request.getParameter(Constant.CUSTOMER.toLowerCase()));
        projectService.create(project, projectManagerId, customerId);

        return Page.REDIRECT_ADMINISTRATOR;
    }

    @RequestMapping(value = "/project{id}", method = RequestMethod.GET)
    public String projectDetails(@PathVariable(value = "id") Long id, HttpServletRequest request) {
        Project project = projectService.details(id);
        List<Sprint> sprintList = sprintService.getSprintList(id);

        for (Sprint s : sprintList) {
            s.setTaskList(taskService.getTaskListBySprint(s.getId()));
            s.setProgress(sprintService.getSprintProgress(s));
            for (Task t : s.getTaskList()) {
                t.setEmployeeList(memberService.getEmployeeListForTask(t.getId()));
            }
        }

        request.setAttribute(Constant.PROJECT, project);
        request.setAttribute(Constant.SPRINT_LIST, sprintList);

        return Page.PROJECT_LIST_POPUP;
    }

    @RequestMapping(value = "/deleteProject{id}", method = RequestMethod.GET)
    public String deleteProject(@PathVariable(value = "id") Long id) {
        projectService.remove(projectService.getProjectById(id));
        return Page.REDIRECT_ADMINISTRATOR;
    }

}
