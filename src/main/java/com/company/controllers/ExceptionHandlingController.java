package com.company.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionHandlingController {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("error");

        return modelAndView;
    }
}
