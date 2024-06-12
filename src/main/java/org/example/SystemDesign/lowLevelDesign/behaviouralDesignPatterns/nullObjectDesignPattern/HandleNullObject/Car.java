package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.nullObjectDesignPattern.HandleNullObject;

public class Car implements Vehicle{

    @Override
    public int getTankCapacity() {
        return 40;
    }

    @Override
    public int getSeatingCapacity() {
        return 5;
    }
}
