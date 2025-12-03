package com.example.simulation_operations_of_an_ngo.Ripa.ProjectManager;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;

public class Performance extends User implements Serializable {
    private int perSc;
    private String evaSum;
    private String reviNAme;
    private String reportPer;
    private String proName;

    public Performance(String email, String password, int perSc, String evaSum, String reviNAme, String reportPer, String proName) {
        super(email, password);
        this.perSc = perSc;
        this.evaSum = evaSum;
        this.reviNAme = reviNAme;
        this.reportPer = reportPer;
        this.proName = proName;
    }

    public int getPerSc() {
        return perSc;
    }

    public void setPerSc(int perSc) {
        this.perSc = perSc;
    }

    public String getEvaSum() {
        return evaSum;
    }

    public void setEvaSum(String evaSum) {
        this.evaSum = evaSum;
    }

    public String getReviNAme() {
        return reviNAme;
    }

    public void setReviNAme(String reviNAme) {
        this.reviNAme = reviNAme;
    }

    public String getReportPer() {
        return reportPer;
    }

    public void setReportPer(String reportPer) {
        this.reportPer = reportPer;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    @Override
    public String toString() {
        return "Performance{" +
                "perSc=" + perSc +
                ", evaSum='" + evaSum + '\'' +
                ", reviNAme='" + reviNAme + '\'' +
                ", reportPer='" + reportPer + '\'' +
                ", proName='" + proName + '\'' +
                '}';
    }
}
