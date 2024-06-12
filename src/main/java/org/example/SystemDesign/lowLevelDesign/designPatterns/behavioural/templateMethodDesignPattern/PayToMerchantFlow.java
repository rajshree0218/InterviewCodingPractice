package org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.templateMethodDesignPattern;

public class PayToMerchantFlow extends PaymentFlow{

    @Override
    public void validateRequest() {
        //specific validation for PayToMerchant flow
        System.out.println("Validate logic for PayToMerchantFlow");
    }

    @Override
    public void calculateFees() {
        //calculate fees for PayToMerchant flow
        System.out.println("2% fee charged for PayToMerchantFlow");

    }

    @Override
    public void debitAmount() {
        //debit amount for PayToMerchant flow
        System.out.println("Debit amount logic for PayToMerchantFlow");
    }

    @Override
    public void creditAmount() {
        //credit amount for PayToMerchant flow
        System.out.println("Credit the remaining amount");
    }
}
