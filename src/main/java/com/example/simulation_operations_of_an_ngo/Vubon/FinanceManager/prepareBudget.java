package com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;
import java.time.LocalDate;

public class prepareBudget extends User implements Serializable {
    private int budgetId;
    private String projectName;
    private int allocatedBudget;
    private int usebudget;
    private LocalDate date;

    public prepareBudget(String email, String password, int budgetId, String projectName, int allocatedBudget, int usebudget, LocalDate date) {
        super(email, password);
        this.budgetId = budgetId;
        this.projectName = projectName;
        this.allocatedBudget = allocatedBudget;
        this.usebudget = usebudget;
        this.date = date;
    }

    public int getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(int budgetId) {
        this.budgetId = budgetId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getAllocatedBudget() {
        return allocatedBudget;
    }

    public void setAllocatedBudget(int allocatedBudget) {
        this.allocatedBudget = allocatedBudget;
    }

    public int getUsebudget() {
        return usebudget;
    }

    public void setUsebudget(int usebudget) {
        this.usebudget = usebudget;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "prepareBudget{" +
                "budgetId=" + budgetId +
                ", projectName='" + projectName + '\'' +
                ", allocatedBudget=" + allocatedBudget +
                ", usebudget=" + usebudget +
                ", date=" + date +
                '}';
    }
}
