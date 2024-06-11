package org.example.SystemDesign.lowLevelDesign.behavioural.strategyPattern.withStrategyPattern;

import org.example.SystemDesign.lowLevelDesign.behavioural.strategyPattern.withStrategyPattern.strategy.DriveStrategy;
import org.example.SystemDesign.lowLevelDesign.behavioural.strategyPattern.withStrategyPattern.strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle{
    OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }
}
