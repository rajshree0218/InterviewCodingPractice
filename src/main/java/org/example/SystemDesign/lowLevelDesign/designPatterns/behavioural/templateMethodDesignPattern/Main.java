package org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.templateMethodDesignPattern;

/*
* Why it's required and when to use:
* When you want all classes to follow the specific steps to process the task but also
* need to provide the flexibility that each class can have their own logic in that specific steps.
* */
public class Main {

    /*
    * Friend -> paying to -> PayToFriendFlow
    * Friend -> paying to -> PayToMerchantFlow
    *
    * Payment :
    * 1. Validate Req.
    * 2. Debit Money
    * 3. Compute Fees
    * 4. Credit Money
    *
    * */
    public static void main(String[] args) {
        PaymentFlow paymentFlow = new PayToFriendFlow();
        paymentFlow.sendMoney();
        System.out.println();
        PaymentFlow paymentFlow2 = new PayToMerchantFlow();
        paymentFlow2.sendMoney();
    }
}
