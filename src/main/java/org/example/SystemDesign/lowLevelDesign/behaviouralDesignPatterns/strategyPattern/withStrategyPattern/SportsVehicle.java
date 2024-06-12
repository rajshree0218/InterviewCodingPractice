package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.strategyPattern.withStrategyPattern;


import org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.strategyPattern.withStrategyPattern.strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {
    SportsVehicle() {
        super(new SportsDriveStrategy());
    }
}
