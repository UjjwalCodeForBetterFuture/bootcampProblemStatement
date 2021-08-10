package org.javaexercises.parkinglot;

import java.util.ArrayList;
import java.util.Optional;

public class Attendant {

    private ArrayList<ParkingLot> parkingLots;

    public Attendant(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
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

    public boolean unParkVehicleFromParkingLot(Object vehicle, ParkingLot parkingLot) {

        return parkingLot.unParkVehicle(vehicle);
    }

}
