package org.example.SystemDesign.lowLevelDesign.designSplitwiseWorking.expense;

import org.example.SystemDesign.lowLevelDesign.designSplitwiseWorking.user.User;
import org.example.SystemDesign.lowLevelDesign.designSplitwiseWorking.split.Split;

import java.util.List;

public class PercentageExpense extends Expense{
    public PercentageExpense(String id, double amount, User paidByUser, String description, List<Split> splits) {
        super(id, amount, paidByUser, description, splits);
    }
}
