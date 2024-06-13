package org.example.SystemDesign.lowLevelDesign.designSplitwise.expense;

import org.example.SystemDesign.lowLevelDesign.designSplitwise.BalanceSheetController;
import org.example.SystemDesign.lowLevelDesign.designSplitwise.expense.split.ExpenseSplit;
import org.example.SystemDesign.lowLevelDesign.designSplitwise.expense.split.Split;
import org.example.SystemDesign.lowLevelDesign.designSplitwise.user.User;

import java.util.List;

public class ExpenseController {

    BalanceSheetController balanceSheetController;
    public ExpenseController(){
        balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser){
        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);
        Expense expense = new Expense (expenseId, description, expenseAmount, paidByUser, splitType, splitDetails);
        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, splitDetails, expenseAmount);
        return expense;
    }

}
