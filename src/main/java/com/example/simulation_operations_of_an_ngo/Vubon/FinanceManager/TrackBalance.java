package com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;
import java.time.LocalDate;

public class TrackBalance extends User implements Serializable {
    private int incomeAmount;
    private String incomecategory;
    private int expenseAmount;
    private String expenseCategory;
    private LocalDate date;

    public TrackBalance(String email, String password, int incomeAmount, String incomecategory, int expenseAmount, String expenseCategory, LocalDate date) {
        super(email, password);
        this.incomeAmount = incomeAmount;
        this.incomecategory = incomecategory;
        this.expenseAmount = expenseAmount;
        this.expenseCategory = expenseCategory;
        this.date = date;
    }

    public int getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(int incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public String getIncomecategory() {
        return incomecategory;
    }

    public void setIncomecategory(String incomecategory) {
        this.incomecategory = incomecategory;
    }

    public int getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(int expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TrackBalance{" +
                "incomeAmount=" + incomeAmount +
                ", incomecategory='" + incomecategory + '\'' +
                ", expenseAmount=" + expenseAmount +
                ", expenseCategory='" + expenseCategory + '\'' +
                ", date=" + date +
                '}';
    }
}
