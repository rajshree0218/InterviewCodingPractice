package org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.mediatorDesignPattern;

public interface Colleague {
    void placeBid(int bidAmount);
    void receiveBidNotification(int bidAmount);
    String getName();
}
