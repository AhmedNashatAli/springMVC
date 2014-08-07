/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.springmvc.dao;

import com.orange.springmvc.domain.Employee;
import java.util.List;

/**
 *
 * @author Ahmed Nashaat OLC
 */
public interface EmployeeDao {

    /**
     *
     * @param fname
     * @param lname
     * @param salary
     *
     * @return
     */
    Employee save(String fname, String lname, int salary);
    /**
     * 
     * @param employee
     * @return 
     */
    void save(Employee employee);

    /**
     *
     * @param EmployeeID
     *
     */
    void delete(Long EmployeeID);
    /**
     * 
     * @param employee 
     */
    void delete(Employee employee);

    /**
     *
     * @param id
     * @param salary
     * @return
     */
    Employee get(Long id);

    /**
     *
     *
     */
    List<Employee> findAll();

    /**
     *
     * @param EmployeeID
     * @param salary
     *
     */
    void update(Long EmployeeID, int salary);
    /**
     * 
     * @param employee 
     */
    Employee update(Employee employee);
    /**
     * 
     * @param firstName
     * @return 
     */
    List<Employee> findAll(String firstName);
    
}
