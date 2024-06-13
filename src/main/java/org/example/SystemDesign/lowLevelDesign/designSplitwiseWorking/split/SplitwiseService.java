package org.example.SystemDesign.lowLevelDesign.designSplitwiseWorking.split;

import org.example.SystemDesign.lowLevelDesign.designSplitwiseWorking.user.User;
import org.example.SystemDesign.lowLevelDesign.designSplitwiseWorking.expense.Expense;
import org.example.SystemDesign.lowLevelDesign.designSplitwiseWorking.group.Group;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitwiseService {
    private Map<String, User> userMap;
    private Map<String, Group> groupMap;
    private Map<String, Map<String, Double>> balanceSheet;

    public SplitwiseService() {
        userMap = new HashMap<>();
        groupMap = new HashMap<>();
        balanceSheet = new HashMap<>();
    }

    public void addUser(User user){
        userMap.put(user.getUserId(), user);
        balanceSheet.put(user.getUserId(), new HashMap<>());
    }

    public void addGroup(Group group){
        groupMap.put(group.getId(), group);
    }

    public void addExpense(Expense expense){
        List<Split> splits = expense.getSplits();
        User paidBy = expense.getPaidByUser();
        double totalAmount = expense.getAmount();

        for(Split split : splits){
            String paidTo = split.getUser().getUserId();
            double amount = split.getAmount();

            if(!balanceSheet.containsKey(paidBy.getUserId())){
                balanceSheet.put(paidBy.getUserId(), new HashMap<>());
            }

            if(!balanceSheet.get(paidBy.getUserId()).containsKey(paidTo)){
                balanceSheet.get(paidBy.getUserId()).put(paidTo, 0.0);
            }

            balanceSheet.get(paidBy.getUserId()).put(
                    paidTo,
                    balanceSheet.get(paidBy.getUserId()).get(paidTo) + amount);

            if(!balanceSheet.containsKey(paidTo)){
                balanceSheet.put(paidTo, new HashMap<>());
            }

            if(!balanceSheet.get(paidTo).containsKey(paidBy.getUserId())){
                balanceSheet.get(paidTo).put(paidBy.getUserId(), 0.0);
            }

            balanceSheet.get(paidTo).put(paidBy.getUserId(), balanceSheet.get(paidTo).get(paidBy.getUserId())-amount);

        }
    }

    public void showBalances(){
        for(String user: balanceSheet.keySet()){
            showBalance(user);
        }
    }

    public void showBalance(String userId){
        boolean isEmpty = true;
        for(Map.Entry<String, Double> entry: balanceSheet.get(userId).entrySet()){
            if(entry.getValue() != 0){
                isEmpty = false;
                printBalance(userId, entry.getKey(), entry.getValue());
            }
        }

        if(isEmpty){
            System.out.println(userId+" has no balance");
        }
    }

    private void printBalance(String user1, String user2, double amount){
        if(amount<0){
            System.out.println(userMap.get(user1).getUserId()+" owes "+ userMap.get(user2).getUserId() + ": " + Math.abs(amount));
        }  else if (amount > 0) {
            System.out.println(userMap.get(user2).getUserId() + " owes " + userMap.get(user1).getUserId() + ": " + Math.abs(amount));
        }

    }
}
