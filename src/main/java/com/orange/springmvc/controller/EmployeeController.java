/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.springmvc.controller;

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

    /**
     *
     * @param model
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/home.htm", method = RequestMethod.GET)
    public void home(Model model, HttpServletResponse response) throws IOException {
        response.getWriter().write("hello!!!!!!");
    }
}
