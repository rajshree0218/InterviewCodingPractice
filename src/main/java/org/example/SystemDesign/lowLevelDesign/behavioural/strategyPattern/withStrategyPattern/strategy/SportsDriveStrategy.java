package org.example.SystemDesign.lowLevelDesign.behavioural.strategyPattern.withStrategyPattern.strategy;

public class SportsDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Sports Drive Capability");
    }
}
