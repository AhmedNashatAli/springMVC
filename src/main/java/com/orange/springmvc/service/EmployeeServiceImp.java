/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.springmvc.service;

import com.orange.springmvc.dao.EmployeeDao;
import com.orange.springmvc.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ahmed Nashaat OLC
 */
@Service("employeeService")
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    @Override
    @Transactional
    public String save(Employee employee) {
        employeeDao.save(employee);
      return "Hello "+employee.getFirstName()+" "+employee.getLastName()+",your salary is "+employee.getSalary()+" and your id ="+employee.getId()+".";
    }

    
}
