package org.example.SystemDesign.lowLevelDesign.designSplitwiseWorking;

import org.example.SystemDesign.lowLevelDesign.designSplitwiseWorking.expense.EqualExpense;
import org.example.SystemDesign.lowLevelDesign.designSplitwiseWorking.expense.Expense;
import org.example.SystemDesign.lowLevelDesign.designSplitwiseWorking.user.User;
import org.example.SystemDesign.lowLevelDesign.designSplitwiseWorking.split.Split;
import org.example.SystemDesign.lowLevelDesign.designSplitwiseWorking.split.SplitwiseService;

import java.util.Arrays;
import java.util.List;

public class Splitwise {
    public static void main(String[] args) {
        SplitwiseService service = new SplitwiseService();

        User u1 = new User("u1", "User1", "1234567890");
        User u2 = new User("u2", "User2", "0987654321");
        User u3 = new User("u3", "User3", "1122334455");

        service.addUser(u1);
        service.addUser(u2);
        service.addUser(u3);

        List<Split> splits = Arrays.asList(new Split(u1, 100), new Split(u2, 100), new Split(u3, 100));
        Expense expense = new EqualExpense("e1", 300, u1,"Lunch", splits);

        service.addExpense(expense);
        service.showBalances();
    }
}
