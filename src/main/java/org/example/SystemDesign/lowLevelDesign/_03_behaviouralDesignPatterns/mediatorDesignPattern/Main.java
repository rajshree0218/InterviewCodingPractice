package org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.mediatorDesignPattern;

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
*
* Mediator looks like Observer or Proxy, but they are not same.
*
* -In Observer Pattern they have multiple observer, any change happen to the observable,
* this notifies to all observer. Like how our mediator is doing. Any message mediator receives
* from any object it calls other, it notifies all others bidder in mediator.
* so intent is different in both pattern and the problem we are solving is different.
*
* -In Proxy Pattern, we have proxy, whenever someone is trying to access the object,
* it goes through the proxy and from proxy it will go to object, and from object it will go to
* proxy and from proxy to other object. here proxy is trying to do lazy loading, whenever request
* come it will have lots of validation and checking, whether are you authorized to invoke this or not etc.
* then based on that it will call actual object.
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
