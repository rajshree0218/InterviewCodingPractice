package org.example.SystemDesign.lowLevelDesign.designParkingLot;

import java.util.*;

// Design Parking Lot
// Amazon Interview Question

// ----start------
abstract class Vehicle {
    private String vehicleNumber;
    private VehicleType type;

    public Vehicle(String licensePlate, VehicleType type) {
        this.vehicleNumber = licensePlate;
        this.type = type;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getType() {
        return type;
    }
}

class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }
}

class Bike extends Vehicle {
    public Bike(String licensePlate) {
        super(licensePlate, VehicleType.BIKE);
    }
}

enum VehicleType {
    CAR, BIKE, TRUCK
}

class ParkingSpot {
    private String id;
    private VehicleType type;
    private boolean isAvailable;

    public ParkingSpot(String id, VehicleType type) {
        this.id = id;
        this.type = type;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void occupySpot() {
        isAvailable = false;
    }

    public void freeSpot() {
        isAvailable = true;
    }

    public VehicleType getType() {
        return type;
    }
}

class Ticket {
    private String id;
    private Vehicle vehicle;
    private long entryTime;
    private long exitTime;
    private double price;

    public Ticket(String id, Vehicle vehicle) {
        this.id = id;
        this.vehicle = vehicle;
        this.entryTime = System.currentTimeMillis();
    }

    public void setExitTime() {
        this.exitTime = System.currentTimeMillis();
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }
}

interface Payment {
    void pay(double amount);
}

class CashPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " in cash.");
    }
}

class CardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using card.");
    }
}

interface PricingStrategy {
    double calculatePrice(long entryTime, long exitTime);
}

class StandardPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(long entryTime, long exitTime) {
        return (exitTime - entryTime) * 0.05; // Example calculation
    }
}

interface ParkingStrategy {
    ParkingSpot findSpot(List<ParkingSpot> spots, Vehicle vehicle);
}

class NearestSpotStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot findSpot(List<ParkingSpot> spots, Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.getType() == vehicle.getType()) {
                return spot;
            }
        }
        return null;
    }
}

class ParkingFloor {
    private String id;
    private List<ParkingSpot> spots;

    public ParkingFloor(String id) {
        this.id = id;
        this.spots = new ArrayList<>();
    }

    public void addParkingSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public String getId() {
        return id;
    }
}

class ParkingLot {
    private String id;
    private Map<String, ParkingFloor> floors;

    public ParkingLot(String id) {
        this.id = id;
        this.floors = new HashMap<>();
    }

    public void addFloor(ParkingFloor floor) {
        floors.put(floor.getId(), floor);
    }

    public ParkingFloor getFloor(String id) {
        return floors.get(id);
    }

    public String getId() {
        return id;
    }

    public Map<String, ParkingFloor> getFloors() {
        return floors;
    }
}

class ParkingManager {
    private ParkingLot parkingLot;
    private PricingStrategy pricingStrategy;
    private ParkingStrategy parkingStrategy;
    private Map<String, Ticket> activeTickets;

    public ParkingManager(ParkingLot parkingLot, PricingStrategy pricingStrategy, ParkingStrategy parkingStrategy) {
        this.parkingLot = parkingLot;
        this.pricingStrategy = pricingStrategy;
        this.parkingStrategy = parkingStrategy;
        this.activeTickets = new HashMap<>();
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : parkingLot.getFloors().values()) {
            ParkingSpot spot = parkingStrategy.findSpot(floor.getSpots(), vehicle);
            if (spot != null) {
                spot.occupySpot();
                Ticket ticket = new Ticket(UUID.randomUUID().toString(), vehicle);
                activeTickets.put(ticket.getId(), ticket);
                return ticket;
            }
        }
        return null; // No spot available
    }

    public double unparkVehicle(String ticketId) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket != null) {
            ticket.setExitTime();
            double price = pricingStrategy.calculatePrice(ticket.getEntryTime(), ticket.getExitTime());
            ticket.setPrice(price);
            return price;
        }
        return 0; // Invalid ticket
    }
}

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("Lot1");
        ParkingFloor floor1 = new ParkingFloor("Floor1");

        floor1.addParkingSpot(new ParkingSpot("Spot1", VehicleType.CAR));
        floor1.addParkingSpot(new ParkingSpot("Spot2", VehicleType.BIKE));

        parkingLot.addFloor(floor1);

        ParkingManager manager = new ParkingManager(parkingLot, new StandardPricingStrategy(), new NearestSpotStrategy());

        Vehicle car = new Car("ABC123");
        Ticket ticket = manager.parkVehicle(car);
        if (ticket != null) {
            System.out.println("Car parked with ticket ID: " + ticket.getId());
        }

        double price = manager.unparkVehicle(ticket.getId());
        System.out.println("Total price for parking: " + price);

        Payment payment = new CashPayment();
        payment.pay(price);
    }
}