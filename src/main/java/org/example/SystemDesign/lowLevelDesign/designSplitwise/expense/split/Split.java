package org.example.SystemDesign.lowLevelDesign.designSplitwise.expense.split;

import org.example.SystemDesign.lowLevelDesign.designSplitwise.user.User;

public class Split {
    User user;
    double amountOne;
    double percentage;

    public Split(User use, double amountOne){
        this.user = user;
        this.amountOne = amountOne;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmountOne() {
        return amountOne;
    }

    public void setAmountOne(double amountOne) {
        this.amountOne = amountOne;
    }
}
