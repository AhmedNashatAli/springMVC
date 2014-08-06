package com.orange.springmvc.controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.orange.springmvc.domain.Employee;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    /**
     *
     * @param model
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/home.htm", method = RequestMethod.GET)
    public void home(HttpServletResponse response) throws IOException {
        response.getWriter().write("hello!!!!!!");
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
}
