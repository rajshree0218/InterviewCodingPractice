package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.nullObjectDesignPattern.HandleNullObject;

import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.nullObjectDesignPattern.HandleNullObject.Vehicle;

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
