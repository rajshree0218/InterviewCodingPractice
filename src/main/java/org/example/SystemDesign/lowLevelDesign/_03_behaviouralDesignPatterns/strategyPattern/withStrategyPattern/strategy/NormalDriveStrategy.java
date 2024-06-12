package org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.strategyPattern.withStrategyPattern.strategy;

public class NormalDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Normal Drive Capability");
    }
}
