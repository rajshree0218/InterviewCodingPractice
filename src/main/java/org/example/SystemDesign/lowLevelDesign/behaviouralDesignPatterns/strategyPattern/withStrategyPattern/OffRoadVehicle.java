package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.strategyPattern.withStrategyPattern;

import org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.strategyPattern.withStrategyPattern.strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle {
    OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }
}
