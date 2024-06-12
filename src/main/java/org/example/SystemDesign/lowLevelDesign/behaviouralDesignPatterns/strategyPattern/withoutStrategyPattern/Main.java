package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.strategyPattern.withoutStrategyPattern;

import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.strategyPattern.withoutStrategyPattern.Vehicle;

public class Main {
    public static void main(String[] args) {

        Vehicle vehicle3 = new GoodsVehicle();
        vehicle3.drive();
    }
}
