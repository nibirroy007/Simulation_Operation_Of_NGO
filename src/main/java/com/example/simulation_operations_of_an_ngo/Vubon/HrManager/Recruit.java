package com.example.simulation_operations_of_an_ngo.Vubon.HrManager;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;
import java.time.LocalDate;

public class Recruit extends User implements Serializable {
    private int employeeId;
    private String employeeName;
    private String status;
    private String role;
    private LocalDate date;

    public Recruit(String email, String password, int employeeId, String employeeName, String status, String role, LocalDate date) {
        super(email, password);
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.status = status;
        this.role = role;
        this.date = date;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", status='" + status + '\'' +
                ", role='" + role + '\'' +
                ", date=" + date +
                '}';
    }
}
