package com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;
import java.time.LocalDate;

public class Audit extends User implements Serializable {
    private int auditId;
    private String name;
    private LocalDate date;
    private String auditStatus;

    public Audit(String email, String password, int auditId, String name, LocalDate date, String auditStatus) {
        super(email, password);
        this.auditId = auditId;
        this.name = name;
        this.date = date;
        this.auditStatus = auditStatus;
    }

    public int getAuditId() {
        return auditId;
    }

    public void setAuditId(int auditId) {
        this.auditId = auditId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    @Override
    public String toString() {
        return "Audit{" +
                "auditId=" + auditId +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", auditStatus='" + auditStatus + '\'' +
                '}';
    }
}
