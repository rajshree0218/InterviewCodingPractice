package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.mediatorDesignPattern;

public interface Colleague {
    void placeBid(int bidAmount);
    void receiveBidNotification(int bidAmount);
    String getName();
}
