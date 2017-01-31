package com.company.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(SQLException.class)
    public ModelAndView handleSqlError(){
        return new ModelAndView(Page.ERROR, Constant.MESSAGE, Constant.SQL_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(){
        return new ModelAndView(Page.ERROR, Constant.MESSAGE, Constant.EXCEPTION);
    }
}
