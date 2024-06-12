package org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.mediatorDesignPattern;

/*
* Mediator Design Pattern
* LLD: Online Auction System
* - The Mediator Pattern is a behavioural design pattern.
* - It encourage loose coupling by keeping objects from referring to each other explicitly
*  and allows them to communicate through a mediator object.
*
*   Mediator design patterns accurately depicts  what they actually wanted to perform,
* objects never interact with each other. they do interact with Mediator.
*
*
* */
public class Main {
    public static void main(String[] args) {
        AuctionMediator auctionMediator = new Auction();
        Colleague bidder1 = new Bidder("A", auctionMediator);
        Colleague bidder2 = new Bidder("B", auctionMediator);

        bidder1.placeBid(2000);
        bidder2.placeBid(3000);
        bidder1.placeBid(4000);
    }
}
