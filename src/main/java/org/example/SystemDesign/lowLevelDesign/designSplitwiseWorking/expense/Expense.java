package org.example.SystemDesign.lowLevelDesign.designSplitwiseWorking.expense;

import org.example.SystemDesign.lowLevelDesign.designSplitwiseWorking.user.User;
import org.example.SystemDesign.lowLevelDesign.designSplitwiseWorking.split.Split;

import java.util.List;

public abstract class Expense {
    private String id;
    private double amount;
    private User paidByUser;
    private String description;
    private List<Split> splits;

    public Expense(String id, double amount, User paidByUser, String description, List<Split> splits) {
        this.id = id;
        this.amount = amount;
        this.paidByUser = paidByUser;
        this.description = description;
        this.splits = splits;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public User getPaidByUser() {
        return paidByUser;
    }

    public String getDescription() {
        return description;
    }

    public List<Split> getSplits() {
        return splits;
    }
}
