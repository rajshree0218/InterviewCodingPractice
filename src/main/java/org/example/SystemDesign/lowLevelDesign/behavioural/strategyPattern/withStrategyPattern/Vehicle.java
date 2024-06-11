package org.example.SystemDesign.lowLevelDesign.behavioural.strategyPattern.withStrategyPattern;

import org.example.SystemDesign.lowLevelDesign.behavioural.strategyPattern.withStrategyPattern.strategy.DriveStrategy;

public class Vehicle {

    DriveStrategy driveStrategy;

    Vehicle(DriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }

    public void drive(){
        driveStrategy.drive();
    }
}
