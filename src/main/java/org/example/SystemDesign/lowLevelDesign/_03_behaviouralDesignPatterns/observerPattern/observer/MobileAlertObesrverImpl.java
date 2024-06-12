package org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.observerPattern.observer;

import org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.observerPattern.observable.StockObservable;

public class MobileAlertObesrverImpl implements NotificationAlertObserver{
    String userName;
    StockObservable stockObservable;

    public MobileAlertObesrverImpl(String userName, StockObservable stockObservable){
        this.userName = userName;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        sendMsgOnMobile(userName);
    }

    private void sendMsgOnMobile(String userName){
        System.out.println("This is to inform you "+userName+" product is in stock hurry up!!");
        // send the actual msg to the end user.
    }
}
