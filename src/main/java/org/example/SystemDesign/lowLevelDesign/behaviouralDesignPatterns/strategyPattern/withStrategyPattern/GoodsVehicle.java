package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.strategyPattern.withStrategyPattern;

import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.strategyPattern.withStrategyPattern.Vehicle;
import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.strategyPattern.withStrategyPattern.strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle {
    GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
