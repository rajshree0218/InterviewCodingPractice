package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.observerPattern.observer;

import org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.observerPattern.observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{

    String emailId;
    StockObservable stockObservable;

    public EmailAlertObserverImpl(String emailId, StockObservable stockObservable){
        this.emailId = emailId;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        sendMail(emailId);
    }

    private void sendMail(String emailId){
        System.out.println("This is to inform you "+emailId+" product is in stock hurry up!!");
        // send the actual mail to the end user.
    }
}
