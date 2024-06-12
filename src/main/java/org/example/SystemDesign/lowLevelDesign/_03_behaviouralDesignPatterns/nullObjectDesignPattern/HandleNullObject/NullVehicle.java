package org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.nullObjectDesignPattern.HandleNullObject;

public class NullVehicle implements Vehicle {

    @Override
    public int getTankCapacity() {
        return 0;
    }

    @Override
    public int getSeatingCapacity() {
        return 0;
    }
}
