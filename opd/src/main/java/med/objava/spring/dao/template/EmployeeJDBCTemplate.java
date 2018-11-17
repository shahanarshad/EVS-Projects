/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package med.objava.spring.dao.template;

import java.sql.Time;
import java.util.List;
import javax.sql.DataSource;
import med.objava.spring.dao.EmployeeDao;
import med.objava.spring.dao.mapper.EmployeeRowMapper;
import med.objava.spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Shahan
 */
public class EmployeeJDBCTemplate implements EmployeeDao {

    @Autowired
    private DataSource dataSource;

    // Employee employee=new Employee(); 
    private JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public Employee get(Integer empId) {
        String sql = query + "WHERE empid=?";
        Employee emp = jdbcTemplateObject
                .queryForObject(
                        sql,
                        new Object[]{empId},
                        new EmployeeRowMapper());
        return emp;
    }

    @Override
    public List<Employee> all() {
        List<Employee> list = jdbcTemplateObject
                .query(query, new EmployeeRowMapper());
        return list;
    }

    @Override
    public void delete(Integer empId) {
        String sql = "DELETE FROM employee "
                + "WHERE empid=?";
        jdbcTemplateObject.update(sql,
                new Object[]{empId});
    }

    @Override
    public void create(Integer empId, Integer userId, String role, String speciality, Time shiftTime, Integer slotSize, Integer availSlotsDay) {
        String sql = "INSERT INTO employee ( empid, userid, role, speciality, shiftTime, slot_size, avail_slots_day ) value (?,?,?,?,?,?,?)";
        jdbcTemplateObject.update(sql, empId, userId, role, speciality, shiftTime, slotSize, availSlotsDay);

    }

    @Override
    public void update(Integer empId, Integer userId, String role, String speciality, Time shift_time, Integer slotSize, Integer availSlotsDay) {
        String sql = "UPDATE employee "
                + "SET "
                + " role=?, speciality=?, shift_time=?, slot_size=?, avail_slots_day=? "
                + "WHERE userid=? OR empid=? ";
        jdbcTemplateObject.update(sql,
                new Object[]{role, speciality, shift_time, slotSize, availSlotsDay, userId, empId});
    }

}//end of class
