package org.javaexercises.parkinglot;

import java.util.HashSet;

import static org.javaexercises.parkinglot.Listener.NULL;

public class ParkingLot {

    private final int maxCapacity;
    private HashSet<Object> vehicles;
    Listener parkingLotListener = NULL;

    public ParkingLot(int maxCapacity) {
        this(maxCapacity, NULL);

    }

    public ParkingLot(int maxCapacity, Listener parkingLotListener) {
        this.maxCapacity = maxCapacity;
        this.vehicles = new HashSet<>(maxCapacity);
        this.parkingLotListener = parkingLotListener;
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
        notifyOwner();
        return true;
    }

    private void notifyOwner() {
        if (isParkingFull()) {
            parkingLotListener.notifyLotFull();
        }
    }

    private void notifyOwnerWhenAvailable() {
        if (!isParkingFull() && vehicles.size() == maxCapacity - 1) {
            parkingLotListener.notifyWhenAvailable();
        }
    }

    private boolean isAlreadyExitInParking(Object vehicle) {
        return vehicles.contains(vehicle);
    }

    public boolean unParkVehicle(Object vehicle) {
        if (isParkingEmpty() || !vehicles.contains(vehicle))
            return false;
        vehicles.remove(vehicle);
        notifyOwnerWhenAvailable();
        return true;
    }
}
