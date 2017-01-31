package com.company.controllers;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.sql.SQLException;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(SQLException.class)
    public ModelAndView handleSqlError() {
        return new ModelAndView(Page.ERROR, Constant.MESSAGE, Constant.SQL_ERROR);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleError404() {
        return new ModelAndView(Page.ERROR, Constant.MESSAGE, Constant.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException() {
        return new ModelAndView(Page.ERROR, Constant.MESSAGE, Constant.EXCEPTION);
    }
}
