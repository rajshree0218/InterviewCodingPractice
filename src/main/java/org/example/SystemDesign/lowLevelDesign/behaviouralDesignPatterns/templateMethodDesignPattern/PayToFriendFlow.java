package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.templateMethodDesignPattern;

public class PayToFriendFlow extends PaymentFlow {

    @Override
    public void validateRequest() {
        //specific validation for PayToFriend flow
        System.out.println("Validate logic for PayToFriendFlow");
    }

    @Override
    public void calculateFees() {
        //calculate fees for PayToFriend flow
        System.out.println("0% fee charged for PayToFriendFlow");

    }

    @Override
    public void debitAmount() {
        //debit amount for PayToFriend flow
        System.out.println("Debit amount logic for PayToFriendFlow");
    }

    @Override
    public void creditAmount() {
        //credit amount for PayToFriend flow
        System.out.println("Credit full amount for PayToFriendFlow");
    }
}
