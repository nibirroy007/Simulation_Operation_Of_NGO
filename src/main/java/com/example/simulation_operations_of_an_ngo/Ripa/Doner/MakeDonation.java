package com.example.simulation_operations_of_an_ngo.Ripa.Doner;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;
import java.time.LocalDate;

public class MakeDonation extends User implements Serializable {
    private int donationId;
    private int donarId;
    private String donationType;
    private String paymentMethod;
    private String projectName;
    private LocalDate date;

    public MakeDonation(String email, String password, int donationId, int donarId, String donationType, String paymentMethod, String projectName, LocalDate date) {
        super(email, password);
        this.donationId = donationId;
        this.donarId = donarId;
        this.donationType = donationType;
        this.paymentMethod = paymentMethod;
        this.projectName = projectName;
        this.date = date;
    }

    public int getDonationId() {
        return donationId;
    }

    public void setDonationId(int donationId) {
        this.donationId = donationId;
    }

    public int getDonarId() {
        return donarId;
    }

    public void setDonarId(int donarId) {
        this.donarId = donarId;
    }

    public String getDonationType() {
        return donationType;
    }

    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MakeDonation{" +
                "donationId=" + donationId +
                ", donarId=" + donarId +
                ", donationType='" + donationType + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", projectName='" + projectName + '\'' +
                ", date=" + date +
                '}';
    }
}
