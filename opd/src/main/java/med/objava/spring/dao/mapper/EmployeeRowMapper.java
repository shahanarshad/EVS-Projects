/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package med.objava.spring.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import med.objava.spring.model.Employee;
import med.objava.spring.model.User;
import org.springframework.jdbc.core.RowMapper;
import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 * @author Shahan
 */
public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int i) throws SQLException {
        Employee emp = new Employee();
        //  Time time = new DateTime();
        emp.setEmpId(rs.getInt("empid"));
        emp.setUserId(rs.getInt("userid"));
        emp.setRole(rs.getString("role"));
        emp.setSpeciality(rs.getString("speciality"));
        Timestamp shiftTimeStamp = rs.getTimestamp("shift_time");
        if (shiftTimeStamp != null) {
            emp.setShiftTime(new Time(shiftTimeStamp.getTime()));
        }
        emp.setSlotSize(rs.getInt("slot_size"));
        emp.setAvailSlotsDay(rs.getInt("avail_slots_day"));
        return emp;
    }

}
