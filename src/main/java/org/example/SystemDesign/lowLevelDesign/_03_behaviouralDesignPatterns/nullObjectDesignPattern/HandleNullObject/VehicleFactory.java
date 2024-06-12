package org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.nullObjectDesignPattern.HandleNullObject;

public class VehicleFactory {


    static Vehicle getVehicleObject(String typeOfVehicle){

        if("Car".equals(typeOfVehicle)) {
            return new Car();
        }
        //handled null object here
        return new NullVehicle();
    }
}
