package com.company.controllers;

import com.company.entities.Member;
import com.company.entities.Sprint;
import com.company.entities.Task;
import com.company.services.impls.ProjectService;
import com.company.services.impls.SprintService;
import com.company.services.impls.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * This class is Controller that contains servlets for work with Sprint.
 */
@Controller
@SessionAttributes(Constant.MEMBER)
public class SprintController {

    @Autowired
    private SprintService sprintService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/newSprint", method = RequestMethod.GET)
    public ModelAndView newSprint(@ModelAttribute Member member) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject(Constant.SPRINT, new Sprint());
        modelAndView.addObject(Constant.ID, sprintService.getSprintNewId());
        modelAndView.addObject(Constant.PROJECT_LIST, projectService.getProjectList(member));
        modelAndView.setViewName(Page.CREATE_SPRINT_POPUP);

        return modelAndView;
    }

    @RequestMapping(value = "/addSprint", method = RequestMethod.POST)
    public String addSprint(@ModelAttribute(Constant.SPRINT) Sprint sprint, HttpServletRequest request) {
        sprint.setProjectId(Long.parseLong(request.getParameter(Constant.PROJECT_ID)));

        sprintService.add(sprint);

        return Page.REDIRECT_DEFAULT;
    }

    @RequestMapping(value = "/sprint{id}", method = RequestMethod.GET)
    public void sprintDetails(@PathVariable long id, HttpServletRequest request) {
        List<Task> taskList = taskService.getTaskListBySprint(id);

        request.setAttribute(Constant.TASK_LIST, taskList);
    }

    @RequestMapping(value = "/sprint{id}_popup", method = RequestMethod.GET)
    public String sprintDetailsPopup(@PathVariable long id, HttpServletRequest request) {
        List<Task> taskList = taskService.getTaskListBySprint(id);

        request.setAttribute(Constant.TASK_LIST, taskList);

        return Page.SPRINT_DETAILS_POPUP;
    }

}
