package com.orange.springmvc.dao;

import com.orange.springmvc.core.dao.AbstractJpaDao;
import com.orange.springmvc.domain.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractJpaDao< Employee >  implements EmployeeDao {
    
    {
              setClazz(Employee.class );
    }
    @PersistenceContext
    private EntityManager em;

    /**
     *
     * @param fname
     * @param lname
     * @param salary
     *
     * @return
     */
    @Override
    public Employee save(String fname, String lname, int salary) {
        Employee employee = new Employee(fname, lname, salary);
       em.persist(employee);
       return employee;
    }


    /**
     *
     * @param EmployeeID
     * @param salary
     *
     */
    @Override
    public void update(Long EmployeeID, int salary) {
        Employee employee = super.get(EmployeeID);
        employee.setSalary(salary);
        em.merge(employee);

    }


    /**
     * 
     * @param firstName
     * @return 
     */
    @Override
    public List<Employee> findAll(String firstName) {
        return em.createQuery("from Employee where firstName like '"+firstName+"'").getResultList();
    }  
}