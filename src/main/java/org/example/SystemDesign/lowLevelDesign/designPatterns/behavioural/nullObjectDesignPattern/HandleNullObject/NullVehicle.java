package org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.nullObjectDesignPattern.HandleNullObject;

public class NullVehicle implements Vehicle{

    @Override
    public int getTankCapacity() {
        return 0;
    }

    @Override
    public int getSeatingCapacity() {
        return 0;
    }
}
