package com.company.controllers;

import com.company.entities.Member;
import com.company.entities.Sprint;
import com.company.entities.Task;
import com.company.services.impls.MemberService;
import com.company.services.impls.SprintService;
import com.company.services.impls.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * This class is Controller that contains servlets for work with Task.
 */
@Controller
@SessionAttributes(Constant.MEMBER)
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private SprintService sprintService;

    @Autowired
    private MemberService memberService;


    @RequestMapping(value = "/newTask", method = RequestMethod.GET)
    public ModelAndView newTask(@ModelAttribute(Constant.MEMBER) Member member){
        ModelAndView modelAndView = new ModelAndView();

        List<Sprint> sprintList = sprintService.getSprintListByMember(member.getId());
        List<Member> memberList = memberService.getAvailableEmployeeList();

        modelAndView.addObject(Constant.TASK, new Task());
        modelAndView.addObject(Constant.ID, taskService.getNewTaskId());
        modelAndView.addObject(Constant.SPRINT_LIST, sprintList);
        modelAndView.addObject(Constant.EMPLOYEE_LIST, memberList);
        modelAndView.setViewName(Page.CREATE_TASK_POPUP);

        return modelAndView;
    }

    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public String addTask(@ModelAttribute(Constant.TASK) Task task, HttpServletRequest request){
        Member taskExecutor = memberService.getMember(Long.parseLong(request.getParameter(Constant.EMPLOYEE.toLowerCase())));
        task.setSprint(Long.parseLong(request.getParameter(Constant.SPRINT)));

        taskService.create(task, taskExecutor);

        return Page.REDIRECT_DEFAULT;
    }

    @RequestMapping(value = "/task{id}", method = RequestMethod.GET)
    public void taskDetails(@PathVariable Long id, HttpServletRequest request){
        Task task = taskService.getTaskById(id);

        request.setAttribute(Constant.TASK, task);
    }
}
