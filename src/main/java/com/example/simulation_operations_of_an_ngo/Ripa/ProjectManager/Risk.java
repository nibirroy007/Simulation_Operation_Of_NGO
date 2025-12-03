package com.example.simulation_operations_of_an_ngo.Ripa.ProjectManager;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;
import java.time.LocalDate;

public class Risk extends User implements Serializable {
    private String riskTitle;
    private String actionPlan;
    private String riskLavel;
    private LocalDate deadLine;

    public Risk(String email, String password, String riskTitle, String actionPlan, String riskLavel, LocalDate deadLine) {
        super(email, password);
        this.riskTitle = riskTitle;
        this.actionPlan = actionPlan;
        this.riskLavel = riskLavel;
        this.deadLine = deadLine;
    }

    public String getRiskTitle() {
        return riskTitle;
    }

    public void setRiskTitle(String riskTitle) {
        this.riskTitle = riskTitle;
    }

    public String getActionPlan() {
        return actionPlan;
    }

    public void setActionPlan(String actionPlan) {
        this.actionPlan = actionPlan;
    }

    public String getRiskLavel() {
        return riskLavel;
    }

    public void setRiskLavel(String riskLavel) {
        this.riskLavel = riskLavel;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return "Risk{" +
                "riskTitle='" + riskTitle + '\'' +
                ", actionPlan='" + actionPlan + '\'' +
                ", riskLavel='" + riskLavel + '\'' +
                ", deadLine=" + deadLine +
                '}';
    }
}
