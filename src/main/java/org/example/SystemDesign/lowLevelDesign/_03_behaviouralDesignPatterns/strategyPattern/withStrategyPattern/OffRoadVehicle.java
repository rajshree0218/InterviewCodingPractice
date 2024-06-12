package org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.strategyPattern.withStrategyPattern;

import org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.strategyPattern.withStrategyPattern.strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle {
    OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }
}
