package org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.strategyPattern.withStrategyPattern;

import org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.strategyPattern.withStrategyPattern.strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle {
    GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
