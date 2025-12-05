package com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;
import java.time.LocalDate;

public class GenerateReport extends User implements Serializable {
    private int reportId;
    private String reporttypr;
    private int yearly;
    private int monthly;
    private int income;
    private int Expense;
    private LocalDate date;

    public GenerateReport(String email, String password, int reportId, String reporttypr, int yearly, int monthly, int income, int expense, LocalDate date) {
        super(email, password);
        this.reportId = reportId;
        this.reporttypr = reporttypr;
        this.yearly = yearly;
        this.monthly = monthly;
        this.income = income;
        Expense = expense;
        this.date = date;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getReporttypr() {
        return reporttypr;
    }

    public void setReporttypr(String reporttypr) {
        this.reporttypr = reporttypr;
    }

    public int getYearly() {
        return yearly;
    }

    public void setYearly(int yearly) {
        this.yearly = yearly;
    }

    public int getMonthly() {
        return monthly;
    }

    public void setMonthly(int monthly) {
        this.monthly = monthly;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getExpense() {
        return Expense;
    }

    public void setExpense(int expense) {
        Expense = expense;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "GenerateReport{" +
                "reportId=" + reportId +
                ", reporttypr='" + reporttypr + '\'' +
                ", yearly=" + yearly +
                ", monthly=" + monthly +
                ", income=" + income +
                ", Expense=" + Expense +
                ", date=" + date +
                '}';
    }
}
