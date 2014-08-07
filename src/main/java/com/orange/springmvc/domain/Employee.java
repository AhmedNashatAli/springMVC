/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.springmvc.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 *
 * @author Ahmed Nashaat OLC
 */
public class Employee {

    private long id;
    @Size(min = 2, max = 30)
    private String firstName;
    @Size(min = 2, max = 30)
    private String lastName;
    @Min(1200)
    private int salary;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
