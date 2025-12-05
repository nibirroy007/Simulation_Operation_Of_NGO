package com.example.simulation_operations_of_an_ngo.Ripa.Doner;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;
import java.time.LocalDate;

public class SelectProject extends User implements Serializable {
    private int proID;
    private String proName;
    private String interestlavel;
    private String projectdes;
    private LocalDate date;

    public SelectProject(String email, String password, int proID, String proName, String interestlavel, String projectdes, LocalDate date) {
        super(email, password);
        this.proID = proID;
        this.proName = proName;
        this.interestlavel = interestlavel;
        this.projectdes = projectdes;
        this.date = date;
    }

    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getInterestlavel() {
        return interestlavel;
    }

    public void setInterestlavel(String interestlavel) {
        this.interestlavel = interestlavel;
    }

    public String getProjectdes() {
        return projectdes;
    }

    public void setProjectdes(String projectdes) {
        this.projectdes = projectdes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SelectProject{" +
                "proID=" + proID +
                ", proName='" + proName + '\'' +
                ", interestlavel='" + interestlavel + '\'' +
                ", projectdes='" + projectdes + '\'' +
                ", date=" + date +
                '}';
    }
}
