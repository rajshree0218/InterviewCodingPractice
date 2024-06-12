package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.mediatorDesignPattern;

import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.mediatorDesignPattern.Colleague;

public interface AuctionMediator {
    void addBidder(org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.mediatorDesignPattern.Colleague bidder);
    void placeBid(Colleague bidder, int bidAmount);
}
