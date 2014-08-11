/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.springmvc.controller;

import com.orange.springmvc.domain.Employee;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.util.Assert;
import static org.hamcrest.Matchers.containsString;

/**
 *
 * @author Ahmed Nashaat OLC
 */
@WebAppConfiguration
@ContextConfiguration({"classpath:com/orange/springmvc/configuration/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeControllerTest {

    @Autowired
    MockHttpSession session;
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void homeTest() throws Exception {
        mockMvc.perform(get("/employee/home.htm")).andExpect(status().isOk()).andExpect(content().string("hello!!!!!!"));
    }

    @Test
    public void employeeFormTest() throws Exception {
        MvcResult result = mockMvc
                .perform(get("/employee/employeeForm.htm"))
                .andExpect(status().isOk())
                .andExpect(view().name("employee/employeeForm"))
                .andExpect(model().attributeExists("employee"))
                //                .andExpect(xpath("//input[@name='summary']").exists())
                //                .andExpect(xpath("//textarea[@name='text']").exists())
                .andReturn();
        MockHttpServletRequest httpServletRequest = result.getRequest();
        Assert.isInstanceOf(Employee.class, httpServletRequest.getAttribute("employee"));
    }

    @Test
    public void saveEmployeeTest() throws Exception {
        Matcher matcher = containsString("Manage Entities");
        MvcResult result = mockMvc.perform(post("/employee/saveEmployee.htm")
                .param("firstName", "Ahmed")
                .param("lastName", "Nashat")
                .param("email", "tali.ext@orange.com")
                .param("salary", "1200")
                .param("phones[0].number", "0100790540"))
                .andExpect(status().isOk())
                .andExpect(view().name("employee/messageAfterSavingEmployee"))
                .andExpect(model().attributeExists("message"))
                .andReturn();
        MockHttpServletRequest httpServletRequest = result.getRequest();
        org.junit.Assert.assertEquals("Hello Ahmed Nashat,your salary is 1200,your mail is tali.ext@orange.com and your phone is 0100790540.", httpServletRequest.getAttribute("message").toString());
    }
}
