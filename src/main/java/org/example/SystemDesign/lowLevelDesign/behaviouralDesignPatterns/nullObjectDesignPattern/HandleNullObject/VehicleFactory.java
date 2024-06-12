package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.nullObjectDesignPattern.HandleNullObject;

import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.nullObjectDesignPattern.HandleNullObject.Car;
import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.nullObjectDesignPattern.HandleNullObject.NullVehicle;
import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.nullObjectDesignPattern.HandleNullObject.Vehicle;

public class VehicleFactory {


    static Vehicle getVehicleObject(String typeOfVehicle){

        if("Car".equals(typeOfVehicle)) {
            return new Car();
        }
        //handled null object here
        return new NullVehicle();
    }
}
