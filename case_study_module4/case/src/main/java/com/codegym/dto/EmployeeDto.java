package com.codegym.dto;

import com.codegym.model.employee.Division;
import com.codegym.model.employee.EducationDegree;
import com.codegym.model.employee.Position;

public class EmployeeDto {
    private Integer employeeId;
    private String employeeName;
    private String employeeBirthday;
    private  String employeeIdCard;
    private String salary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;
    private boolean isDelete;
    private Division division;
    private Position position;
    private EducationDegree educationDegree;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }
}
