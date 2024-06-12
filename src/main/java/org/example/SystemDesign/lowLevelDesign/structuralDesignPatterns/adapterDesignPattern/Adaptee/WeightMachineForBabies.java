package org.example.SystemDesign.lowLevelDesign.structuralDesignPatterns.adapterDesignPattern.Adaptee;

public class WeightMachineForBabies implements WeightMachine{
    @Override
    public double getWeightInPound() {
        return 28;
    }
}
