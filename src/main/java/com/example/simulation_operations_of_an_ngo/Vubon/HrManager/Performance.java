package com.example.simulation_operations_of_an_ngo.Vubon.HrManager;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;
import java.time.LocalDate;

public class Performance extends User implements Serializable {
    private String employeeId;
    private String emplName;
    private LocalDate date;
    private String performanceScore;

    public Performance(String email, String password, String employeeId, String emplName, LocalDate date, String performanceScore) {
        super(email, password);
        this.employeeId = employeeId;
        this.emplName = emplName;
        this.date = date;
        this.performanceScore = performanceScore;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmplName() {
        return emplName;
    }

    public void setEmplName(String emplName) {
        this.emplName = emplName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(String performanceScore) {
        this.performanceScore = performanceScore;
    }

    @Override
    public String toString() {
        return "Performance{" +
                "employeeId='" + employeeId + '\'' +
                ", emplName='" + emplName + '\'' +
                ", date=" + date +
                ", performanceScore='" + performanceScore + '\'' +
                '}';
    }
}
