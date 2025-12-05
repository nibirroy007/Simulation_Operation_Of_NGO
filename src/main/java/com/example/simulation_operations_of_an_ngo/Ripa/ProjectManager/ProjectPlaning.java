package com.example.simulation_operations_of_an_ngo.Ripa.ProjectManager;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;
import java.time.LocalDate;

public class ProjectPlaning extends User implements Serializable {
    private String titleProject;
    private LocalDate startdate;
    private LocalDate endDate;
    private String deliveries;
    private String status;

    public ProjectPlaning(String email, String password, String titleProject, LocalDate startdate, LocalDate endDate, String deliveries, String status) {
        super(email, password);
        this.titleProject = titleProject;
        this.startdate = startdate;
        this.endDate = endDate;
        this.deliveries = deliveries;
        this.status = status;
    }

    public String getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(String deliveries) {
        this.deliveries = deliveries;
    }

    public String getTitleProject() {
        return titleProject;
    }

    public void setTitleProject(String titleProject) {
        this.titleProject = titleProject;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProjectPlaning{" +
                "titleProject='" + titleProject + '\'' +
                ", startdate=" + startdate +
                ", endDate=" + endDate +
                ", deliveries='" + deliveries + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
