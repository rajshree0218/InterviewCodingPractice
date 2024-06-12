package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.strategyPattern.withoutStrategyPattern;

import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.strategyPattern.withoutStrategyPattern.Vehicle;

public class PassengerVehicle extends Vehicle {
    public void drive(){
        // some code
        System.out.println("Passenger drive capability");
    }
}
