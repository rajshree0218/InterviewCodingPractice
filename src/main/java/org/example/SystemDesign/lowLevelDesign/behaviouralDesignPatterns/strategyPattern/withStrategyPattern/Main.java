package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.strategyPattern.withStrategyPattern;

import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.strategyPattern.withStrategyPattern.Vehicle;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new SportsVehicle();
        vehicle.drive();

        Vehicle vehicle2 = new OffRoadVehicle();
        vehicle2.drive();

        Vehicle vehicle3 = new GoodsVehicle();
        vehicle3.drive();
    }
}
