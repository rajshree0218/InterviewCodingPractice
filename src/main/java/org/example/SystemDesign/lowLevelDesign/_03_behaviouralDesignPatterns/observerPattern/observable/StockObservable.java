package org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.observerPattern.observable;

import org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.observerPattern.observer.NotificationAlertObserver;

public interface StockObservable {

    public void add(NotificationAlertObserver observer);
    public void remove(NotificationAlertObserver observer);
    public void notifySubscriber();
    public void setStockCount(int stockAdded);
    public int getStockCount();
}
