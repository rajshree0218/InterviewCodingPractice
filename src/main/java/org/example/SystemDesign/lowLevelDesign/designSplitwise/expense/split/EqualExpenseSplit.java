package org.example.SystemDesign.lowLevelDesign.designSplitwise.expense.split;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit{

    @Override
    public void validateSplitRequest(List<Split> splitList, double totalAmount) {
        // validate total amount in split of each user is equal and overall equal to total amount or not
        double amountShouldBePresent = totalAmount / splitList.size();
        for(Split split : splitList){
            if(split.getAmountOne()!= amountShouldBePresent){
                // throw exception
            }
        }
    }
}
