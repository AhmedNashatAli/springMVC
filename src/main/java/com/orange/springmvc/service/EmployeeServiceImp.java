/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.springmvc.service;

import com.orange.springmvc.domain.Employee;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ahmed Nashaat OLC
 */
@Service("employeeService")
public class EmployeeServiceImp implements EmployeeService {

    @Override
    public String save(Employee employee) {
      return "Hello "+employee.getFirstName()+" "+employee.getLastName()+",your salary is "+employee.getSalary()+".";
    }

    
}
