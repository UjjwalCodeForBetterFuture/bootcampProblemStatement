package org.javaexercises.parkinglot;

import java.util.*;

public class Attendant implements ParkingLotListener {

    private List<ParkingLot> parkingLots;
    private Set<ParkingLot> fullParkingSlot = new HashSet<>();

    public Attendant(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;

        // Nice concept
        for (ParkingLot parkingLot : parkingLots) {
            parkingLot.registerListener(this);
        }
    }

    public ParkingLot parkVehicleInFreeParkingLot(Object vehicle) throws Exception {
        final Optional<ParkingLot> parkingLotFound = parkingLots.stream()
                .filter(parkingLot -> parkingLot.parkVehicle(vehicle))
                .findFirst();
        if (!parkingLotFound.isPresent()) {
            throw new Exception("parking lots all full");
        }
        return parkingLotFound.get();
    }

    public ParkingLot parkVehicleFromObserverPattern(Object vehicle) throws Exception {
        return getFreeParkingLot(vehicle);
    }

    private ParkingLot getFreeParkingLot(Object vehicle) throws Exception {
        for (ParkingLot parkingLot : parkingLots) {
            if (!fullParkingSlot.contains(parkingLot)) {
                parkingLot.parkVehicle(vehicle);
                return parkingLot;
            }
        }
        throw new Exception("parking lots all full");
    }

    public boolean unParkVehicleFromParkingLot(Object vehicle, ParkingLot parkingLot) {
        return parkingLot.unParkVehicle(vehicle);
    }

    @Override
    public void notifyLotFull(ParkingLot parkingLot) {
        fullParkingSlot.add(parkingLot);
    }

    @Override
    public void notifyWhenAvailable(ParkingLot parkingLot) {
        fullParkingSlot.remove(parkingLot);
    }
}
