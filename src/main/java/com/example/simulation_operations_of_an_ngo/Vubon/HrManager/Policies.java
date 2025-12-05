package com.example.simulation_operations_of_an_ngo.Vubon.HrManager;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;
import java.time.LocalDate;

public class Policies extends User implements Serializable {
    private int id;
    private String polName;
    private String polCat;
    private LocalDate date;

    public Policies(String email, String password, int id, String polName, String polCat, LocalDate date) {
        super(email, password);
        this.id = id;
        this.polName = polName;
        this.polCat = polCat;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPolName() {
        return polName;
    }

    public void setPolName(String polName) {
        this.polName = polName;
    }

    public String getPolCat() {
        return polCat;
    }

    public void setPolCat(String polCat) {
        this.polCat = polCat;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Policies{" +
                "id=" + id +
                ", polName='" + polName + '\'' +
                ", polCat='" + polCat + '\'' +
                ", date=" + date +
                '}';
    }
}
