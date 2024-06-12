package org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.mediatorDesignPattern;

public interface Colleague {
    void placeBid(int bidAmount);
    void receiveBidNotification(int bidAmount);
    String getName();
}
