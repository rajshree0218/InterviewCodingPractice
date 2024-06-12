package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.nullObjectDesignPattern.HandleNullObject;

import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.nullObjectDesignPattern.HandleNullObject.Vehicle;

/*
* Object either will have null as a value or it will have specific value.
*
* - A null object replace NULL return type.
* - No need to put IF check for checking null.
* - null object reflects do nothing or default behaviour.
* */
public class Main {

    public static void main(String args[]){

        Vehicle vehicle = VehicleFactory.getVehicleObject("Car");
        printVehicleDetails(vehicle);

        //handling null objects as in the vehicle factory we have not added code for bike check. hence it will throw NPE if we don't handle it.
        Vehicle vehicle2 = VehicleFactory.getVehicleObject("Bike");
        printVehicleDetails(vehicle2);
    }

    private static void printVehicleDetails(Vehicle vehicle) {
            System.out.println("Seating Capacity: " + vehicle.getSeatingCapacity());
            System.out.println("Fuel Tank Capacity: " + vehicle.getTankCapacity());
    }



    /*
    private static void printVehicleDetails(Vehicle vehicle) {
            System.out.println("Seating Capacity: " + vehicle.getSeatingCapacity());
            System.out.println("Fuel Tank Capacity: " + vehicle.getTankCapacity());
    }
    * this is possibly solution to handle NPE bug in this piece of code,
    * if null object was not handled through design pattern.
    * */
    private static void printVehicleDetailsSolution(Vehicle vehicle) {
        if(vehicle!=null) {
            System.out.println("Seating Capacity: " + vehicle.getSeatingCapacity());
            System.out.println("Fuel Tank Capacity: " + vehicle.getTankCapacity());
        }
    }
}
