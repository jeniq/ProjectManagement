package com.company.controllers;

import com.company.entities.Task;
import com.company.services.impls.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * This class is Controller that contains servlets for work with Task.
 */
@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public void addTask(@SessionAttribute Task task){
        taskService.add(task);
    }

    @RequestMapping(value = "/task{id}", method = RequestMethod.GET)
    public void taskDetails(@PathVariable Long id, HttpServletRequest request){
        Task task = taskService.getTaskById(id);

        request.setAttribute(Constant.TASK, task);
    }
}
