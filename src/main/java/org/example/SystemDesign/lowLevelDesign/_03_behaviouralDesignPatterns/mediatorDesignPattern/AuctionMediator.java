package org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.mediatorDesignPattern;


public interface AuctionMediator {
    void addBidder(Colleague bidder);
    void placeBid(Colleague bidder, int bidAmount);
}
