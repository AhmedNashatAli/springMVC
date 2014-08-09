package com.orange.springmvc.controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.orange.springmvc.domain.Employee;
import com.orange.springmvc.service.EmployeeService;
import java.io.IOException;
import java.util.Locale;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ahmed Nashaat OLC
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private String commonPackage = "employee/";
    @Autowired
    private EmployeeService employeeService;
     @Autowired
    private MessageSource messageSource;
    /**
     *
     * @param model
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/home.htm", method = RequestMethod.GET)
    public void home(Locale locale,HttpServletResponse response) throws IOException {
        String responseMessage = messageSource.getMessage("home.welcome", null, locale);
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().write(responseMessage);
    }
    /**
     * 
     * @param model
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(value = "/employeeForm.htm", method = RequestMethod.GET)
    public String employeeForm(Model model) throws IOException {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return commonPackage + "employeeForm";
    }
    /**
     * 
     * @param employee
     * @return
     * @throws IOException 
     */
    @RequestMapping(value = "/saveEmployee.htm", method = RequestMethod.POST)
    public String employeeForm(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult,Model model) throws IOException {
         
         if (bindingResult.hasErrors()) {
           model.addAttribute("errorList", bindingResult.getAllErrors());
           model.addAttribute("employee", employee);
             return commonPackage + "employeeForm";
        }else{
        model.addAttribute("message", employeeService.save(employee));
    }
        return commonPackage + "messageAfterSavingEmployee";
    }
}
