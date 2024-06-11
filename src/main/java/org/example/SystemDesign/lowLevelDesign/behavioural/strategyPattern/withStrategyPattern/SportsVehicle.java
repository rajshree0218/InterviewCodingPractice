package org.example.SystemDesign.lowLevelDesign.behavioural.strategyPattern.withStrategyPattern;

import org.example.SystemDesign.lowLevelDesign.behavioural.strategyPattern.withStrategyPattern.strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle{
    SportsVehicle() {
        super(new SportsDriveStrategy());
    }
}
