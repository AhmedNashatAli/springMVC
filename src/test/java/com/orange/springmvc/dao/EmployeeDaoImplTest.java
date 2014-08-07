package com.orange.springmvc.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.orange.springmvc.domain.Employee;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ahmed Nashaat OLC
 */
@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration({"classpath:com/orange/springmvc/configuration/applicationContext.xml"})
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeDaoImplTest {

    @Autowired
    private EmployeeDao employeeDao;

    /**
     * test employee insertion
     */
    @Test
    public void insertEmployeeTest() {
        Employee employee=employeeDao.save("ahmed", "nashat", 1200);
        assertNotNull(employee.getId());        
    }

}