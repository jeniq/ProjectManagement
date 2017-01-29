package com.company.controllers;

import com.company.entities.Sprint;
import com.company.entities.Task;
import com.company.services.impls.SprintService;
import com.company.services.impls.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * This class is Controller that contains servlets for work with Sprint.
 */
@Controller
public class SprintController {

    @Autowired
    private SprintService sprintService;

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/addSprint", method = RequestMethod.POST)
    public void addSprint(@ModelAttribute("sprint") Sprint sprint){
        sprintService.add(sprint);
    }

    @RequestMapping(value = "/sprint{id}", method = RequestMethod.GET)
    public void sprintDetails(@PathVariable long id, HttpServletRequest request){
        List<Task> taskList = taskService.getTaskListBySprint(id);

        request.setAttribute(Constant.TASK_LIST, taskList);
    }

    @RequestMapping(value = "/sprint{id}_popup", method = RequestMethod.GET)
    public String sprintDetailsPopup(@PathVariable long id, HttpServletRequest request){
        List<Task> taskList = taskService.getTaskListBySprint(id);

        request.setAttribute(Constant.TASK_LIST, taskList);

        return Page.SPRINT_DETAILS_POPUP;
    }

}
