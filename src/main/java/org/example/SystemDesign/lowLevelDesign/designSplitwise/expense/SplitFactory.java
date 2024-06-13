package org.example.SystemDesign.lowLevelDesign.designSplitwise.expense;

import org.example.SystemDesign.lowLevelDesign.designSplitwise.expense.split.EqualExpenseSplit;
import org.example.SystemDesign.lowLevelDesign.designSplitwise.expense.split.ExpenseSplit;
import org.example.SystemDesign.lowLevelDesign.designSplitwise.expense.split.PercentageExpenseSplit;
import org.example.SystemDesign.lowLevelDesign.designSplitwise.expense.split.UnequalExpenseSplit;

public class SplitFactory {

    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType){
        switch (splitType){
            case EQUAL:
                return new EqualExpenseSplit();
            case UNEQUAL:
                return new UnequalExpenseSplit();
            case PERCENTAGE:
                return new PercentageExpenseSplit();
            default:
                return null;
        }
    }
}
