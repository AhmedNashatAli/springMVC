/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.springmvc.controller;

import com.orange.springmvc.domain.Employee;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.util.Assert;
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
                .andReturn();
        MockHttpServletRequest httpServletRequest=result.getRequest();
        Assert.isInstanceOf(Employee.class,httpServletRequest.getAttribute("employee"));
    }
}
