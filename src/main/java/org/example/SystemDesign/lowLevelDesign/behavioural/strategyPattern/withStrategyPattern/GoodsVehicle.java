package org.example.SystemDesign.lowLevelDesign.behavioural.strategyPattern.withStrategyPattern;

import org.example.SystemDesign.lowLevelDesign.behavioural.strategyPattern.withStrategyPattern.strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle{
    GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
