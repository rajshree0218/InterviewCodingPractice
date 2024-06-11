package org.example.SystemDesign.lowLevelDesign.behavioural.strategyPattern.withStrategyPattern.strategy;

public class NormalDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Normal Drive Capability");
    }
}
