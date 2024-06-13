package org.example.SystemDesign.lowLevelDesign.designSplitwise.expense.split;

import java.util.List;

public interface ExpenseSplit {
     public void validateSplitRequest(List<Split> splitList, double totalAmount);
}
