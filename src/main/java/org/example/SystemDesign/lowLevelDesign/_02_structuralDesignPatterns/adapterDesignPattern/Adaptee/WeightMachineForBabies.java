package org.example.SystemDesign.lowLevelDesign._02_structuralDesignPatterns.adapterDesignPattern.Adaptee;

public class WeightMachineForBabies implements WeightMachine{
    @Override
    public double getWeightInPound() {
        return 28;
    }
}
