package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.strategyPattern.withStrategyPattern;

import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.strategyPattern.withStrategyPattern.Vehicle;
import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.strategyPattern.withStrategyPattern.strategy.DriveStrategy;
import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.strategyPattern.withStrategyPattern.strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle {
    OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }
}
