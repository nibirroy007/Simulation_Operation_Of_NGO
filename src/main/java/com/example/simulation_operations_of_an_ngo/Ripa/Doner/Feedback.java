package com.example.simulation_operations_of_an_ngo.Ripa.Doner;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;

public class Feedback extends User implements Serializable {
    private int fedId;
    private int donarId;
    private String projectname;
    private String fedbackMessage;

    public Feedback(String email, String password, int fedId, int donarId, String projectname, String fedbackMessage) {
        super(email, password);
        this.fedId = fedId;
        this.donarId = donarId;
        this.projectname = projectname;
        this.fedbackMessage = fedbackMessage;
    }

    public int getFedId() {
        return fedId;
    }

    public void setFedId(int fedId) {
        this.fedId = fedId;
    }

    public int getDonarId() {
        return donarId;
    }

    public void setDonarId(int donarId) {
        this.donarId = donarId;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getFedbackMessage() {
        return fedbackMessage;
    }

    public void setFedbackMessage(String fedbackMessage) {
        this.fedbackMessage = fedbackMessage;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "fedId=" + fedId +
                ", donarId=" + donarId +
                ", projectname='" + projectname + '\'' +
                ", fedbackMessage='" + fedbackMessage + '\'' +
                '}';
    }
}
