package org.example.SystemDesign.lowLevelDesign.designSplitwiseWorking.split;

import org.example.SystemDesign.lowLevelDesign.designSplitwiseWorking.user.User;

public class Split {
    private User user;
    private double amount;

    public Split(User user, double amount) {
        this.user = user;
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }
}
