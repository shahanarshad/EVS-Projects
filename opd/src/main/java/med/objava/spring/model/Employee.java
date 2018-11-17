package med.objava.spring.model;

import java.sql.Time;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Shahan
 */
public class Employee {

    private Integer empId;
    private String role;
    private String speciality;
    private Time shiftTime;
    private Integer slotSize;
    private Integer availSlotsDay;

//User Class object
    User user = new User();

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
    
    public Integer getUserId()
    {
      return user.getUserid();
    }
    
    public void setUserId(Integer userId)
    {
      this.user.setUserid(userId);
    }
    

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Time getShiftTime() {
        return shiftTime;
    }

    public void setShiftTime(Time shiftTime) {
        this.shiftTime = shiftTime;
    }

    public Integer getSlotSize() {
        return slotSize;
    }

    public void setSlotSize(Integer slotSize) {
        this.slotSize = slotSize;
    }

    public Integer getAvailSlotsDay() {
        return availSlotsDay;
    }

    public void setAvailSlotsDay(Integer availSlotsDay) {
        this.availSlotsDay = availSlotsDay;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}//end of class
