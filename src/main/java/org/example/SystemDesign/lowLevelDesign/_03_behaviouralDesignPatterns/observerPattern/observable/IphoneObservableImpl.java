package org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.observerPattern.observable;

import org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.observerPattern.observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable {

    public List<NotificationAlertObserver> list = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver observer) {
        list.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        list.remove(observer);
    }

    @Override
    public void notifySubscriber() {
        for(NotificationAlertObserver observer: list){
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        System.out.println(stockCount+" :: "+newStockAdded);
        if(stockCount==0){
            notifySubscriber();
        }
        stockCount += newStockAdded;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
