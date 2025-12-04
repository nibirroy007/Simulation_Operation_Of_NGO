package com.example.simulation_operations_of_an_ngo.Vubon.HrManager;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;
import java.time.LocalDate;

public class Payroll extends User implements Serializable {
    private int auId;
    private String auName;
    private String orgName;
    private String auditType;
    private LocalDate date;

    public Payroll(String email, String password, int auId, String auName, String orgName, String auditType, LocalDate date) {
        super(email, password);
        this.auId = auId;
        this.auName = auName;
        this.orgName = orgName;
        this.auditType = auditType;
        this.date = date;
    }

    public int getAuId() {
        return auId;
    }

    public void setAuId(int auId) {
        this.auId = auId;
    }

    public String getAuName() {
        return auName;
    }

    public void setAuName(String auName) {
        this.auName = auName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Payroll{" +
                "auId=" + auId +
                ", auName='" + auName + '\'' +
                ", orgName='" + orgName + '\'' +
                ", auditType='" + auditType + '\'' +
                ", date=" + date +
                '}';
    }
}
