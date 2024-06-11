package org.example.SystemDesign.lowLevelDesign.behavioural.observerPattern.observable;

import org.example.SystemDesign.lowLevelDesign.behavioural.observerPattern.observer.NotificationAlertObserver;

public interface StockObservable {

    public void add(NotificationAlertObserver observer);
    public void remove(NotificationAlertObserver observer);
    public void notifySubscriber();
    public void setStockCount(int stockAdded);
    public int getStockCount();
}
