package org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.nullObjectDesignPattern.HandleNullObject;

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
