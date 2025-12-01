package com.example.simulation_operations_of_an_ngo.Ripa.ProjectManager;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;

public class ProgressMonitoring extends User implements Serializable {
    private String projectProgress;
    private String resourceUsed;
    private String reamingres;
    private String notes;

    public ProgressMonitoring(String email, String password, String projectProgress, String resourceUsed, String reamingres, String notes) {
        super(email, password);
        this.projectProgress = projectProgress;
        this.resourceUsed = resourceUsed;
        this.reamingres = reamingres;
        this.notes = notes;
    }

    public String getProjectProgress() {
        return projectProgress;
    }

    public void setProjectProgress(String projectProgress) {
        this.projectProgress = projectProgress;
    }

    public String getResourceUsed() {
        return resourceUsed;
    }

    public void setResourceUsed(String resourceUsed) {
        this.resourceUsed = resourceUsed;
    }

    public String getReamingres() {
        return reamingres;
    }

    public void setReamingres(String reamingres) {
        this.reamingres = reamingres;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "ProgressMonitoring{" +
                "projectProgress='" + projectProgress + '\'' +
                ", resourceUsed='" + resourceUsed + '\'' +
                ", reamingres='" + reamingres + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
