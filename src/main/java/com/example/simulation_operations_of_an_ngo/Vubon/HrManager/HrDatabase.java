package com.example.simulation_operations_of_an_ngo.Vubon.HrManager;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;

public class HrDatabase extends User implements Serializable {
    private int employeeId;
    private String employeeName;
    private String status;
    private String role;
    private int volId;
    private String volName;

    public HrDatabase(String email, String password, int employeeId, String employeeName, String status, String role, int volId, String volName) {
        super(email, password);
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.status = status;
        this.role = role;
        this.volId = volId;
        this.volName = volName;
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

    public int getVolId() {
        return volId;
    }

    public void setVolId(int volId) {
        this.volId = volId;
    }

    public String getVolName() {
        return volName;
    }

    public void setVolName(String volName) {
        this.volName = volName;
    }

    @Override
    public String toString() {
        return "HrDatabase{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", status='" + status + '\'' +
                ", role='" + role + '\'' +
                ", volId=" + volId +
                ", volName='" + volName + '\'' +
                '}';
    }
}
