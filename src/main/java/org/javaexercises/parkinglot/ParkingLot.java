package org.javaexercises.parkinglot;

import java.util.HashSet;

public class ParkingLot {

    private final int maxCapacity;
    private HashSet<Object> vehicles;

    public ParkingLot(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.vehicles = new HashSet<>(maxCapacity);
    }

    public boolean isParkingFull() {
        return vehicles.size() >= maxCapacity;
    }

    public boolean isParkingEmpty() {
        return vehicles.size() <= 0;

    }

    public boolean parkVehicle(Object vehicle) {
        if (isAlreadyExitInParking(vehicle) || isParkingFull())
            return false;
        vehicles.add(vehicle);
        return true;
    }

    private boolean isAlreadyExitInParking(Object vehicle) {
        return vehicles.contains(vehicle);
    }

    public boolean unParkVehicle(Object vehicle) {
        if (isParkingEmpty() || !vehicles.contains(vehicle))
            return false;
        vehicles.remove(vehicle);
        return true;
    }
}
