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
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < employee.getPhones().size(); i++) {
            stringBuilder.append(employee.getPhones().get(i).getNumber());
            stringBuilder.append(" ");
        }
      return "Hello "+employee.getFirstName()+" "+employee.getLastName()+",your salary is "+employee.getSalary()+",your mail is "+employee.getEmail()+" and your phone is "+stringBuilder+".";
    }

    
}
