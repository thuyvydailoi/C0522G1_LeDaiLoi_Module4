package com.codegym.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer divisionId;
    private String divisionName;

    @OneToMany(mappedBy = "division")
    private Set<Employee> employeeSet;

    public Division() {
    }

    public Division(Integer divisionId, String divisionName, Set<Employee> employeeSet) {
        this.divisionId = divisionId;
        this.divisionName = divisionName;
        this.employeeSet = employeeSet;
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
