package com.company.controllers;

import com.company.entities.Project;
import com.company.services.impls.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/newProject", method = RequestMethod.GET)
    public String createProject(){

        return "newProject";
    }

    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public String addProject(@ModelAttribute Project project){
        projectService.add(project);
        // possible to make pop-up with result of adding
        return ""; // to admin page
    }



}
