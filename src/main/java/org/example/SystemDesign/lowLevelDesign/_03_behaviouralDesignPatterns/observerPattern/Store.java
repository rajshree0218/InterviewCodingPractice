package org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.observerPattern;


import org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.observerPattern.observable.IphoneObservableImpl;
import org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.observerPattern.observable.StockObservable;
import org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.observerPattern.observer.EmailAlertObserverImpl;
import org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.observerPattern.observer.MobileAlertObesrverImpl;
import org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.observerPattern.observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {

        StockObservable iphoneObservable = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("xyz@gmail.com", iphoneObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("xyz@gmail.com", iphoneObservable);
        NotificationAlertObserver observer3 = new MobileAlertObesrverImpl("xyz_userName", iphoneObservable);

        iphoneObservable.add(observer1);
        iphoneObservable.add(observer2);
        iphoneObservable.add(observer3);

        iphoneObservable.setStockCount(10);
        iphoneObservable.setStockCount(0);
        iphoneObservable.setStockCount(100);
    }
}
