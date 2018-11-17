/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package med.objava.spring.dao;

import java.sql.Time;
import java.util.List;
import javax.sql.DataSource;
import med.objava.spring.model.Employee;
import med.objava.spring.model.User;

/**
 *
 * @author Shahan
 */
public interface EmployeeDao {
    

 public String query = "SELECT empid,userid,role,speciality,shift_time,slot_size,avail_slots_day FROM employee" ;

    public void setDataSource(DataSource ds);

    public void create(Integer empId,Integer userId, String role, String speciality,Time shift_time, Integer slotSize, Integer availSlotsDay);

    public Employee get(Integer empId);

    public List<Employee> all();

    public void delete(Integer empId);

    public void update(Integer empId,Integer userId, String role, String speciality,Time shiftTime, Integer slotSize, Integer availSlotsDay);

}
