package com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;

public class ManageDonation extends User implements Serializable {
    private int reqId;
    private String reqNAme;
    private int reqamount;
    private int approvemaount;
    private String status;

    public ManageDonation(String email, String password, int reqId, String reqNAme, int reqamount, int approvemaount, String status) {
        super(email, password);
        this.reqId = reqId;
        this.reqNAme = reqNAme;
        this.reqamount = reqamount;
        this.approvemaount = approvemaount;
        this.status = status;
    }

    public int getReqId() {
        return reqId;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
    }

    public String getReqNAme() {
        return reqNAme;
    }

    public void setReqNAme(String reqNAme) {
        this.reqNAme = reqNAme;
    }

    public int getReqamount() {
        return reqamount;
    }

    public void setReqamount(int reqamount) {
        this.reqamount = reqamount;
    }

    public int getApprovemaount() {
        return approvemaount;
    }

    public void setApprovemaount(int approvemaount) {
        this.approvemaount = approvemaount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ManageDonation{" +
                "reqId=" + reqId +
                ", reqNAme='" + reqNAme + '\'' +
                ", reqamount=" + reqamount +
                ", approvemaount=" + approvemaount +
                ", status='" + status + '\'' +
                '}';
    }
}
