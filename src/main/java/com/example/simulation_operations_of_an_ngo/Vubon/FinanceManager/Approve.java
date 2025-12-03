package com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;

public class Approve extends User implements Serializable {
    private String projectName;
    private int reqId;
    private int amount;
    private String requestBy;
    private String status;

    public Approve(String email, String password, String projectName, int reqId, int amount, String requestBy, String status) {
        super(email, password);
        this.projectName = projectName;
        this.reqId = reqId;
        this.amount = amount;
        this.requestBy = requestBy;
        this.status = status;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getReqId() {
        return reqId;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(String requestBy) {
        this.requestBy = requestBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Approve{" +
                "projectName='" + projectName + '\'' +
                ", reqId=" + reqId +
                ", amount=" + amount +
                ", requestBy='" + requestBy + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
