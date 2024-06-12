package org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.mediatorDesignPattern;

public interface AuctionMediator {
    void addBidder(Colleague bidder);
    void placeBid(Colleague bidder, int bidAmount);
}
