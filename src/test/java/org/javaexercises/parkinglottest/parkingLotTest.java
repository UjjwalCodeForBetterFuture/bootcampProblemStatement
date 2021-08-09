package org.javaexercises.parkinglottest;

import org.javaexercises.parkinglot.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class parkingLotTest {

    @Test
    public void checkParkingAvailableWith10Slots() {
        ParkingLot parkingLot = new ParkingLot(10);
        assertTrue(parkingLot.parkVehicle(new Object()));

    }

    @Test
    public void checkParkingAvailableWithExistingVehicle() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.parkVehicle(new Object());
        assertFalse(parkingLot.parkVehicle(new Object()));
    }

    @Test
    public void shouldNotBeAbleToUnparkFromEmptyParkingLot() {
        ParkingLot parkingLot = new ParkingLot(0);
        assertFalse(parkingLot.unParkVehicle(new Object()));
    }

    @Test
    public void shouldBeUnparkAVehicle() {
        ParkingLot parkingLot = new ParkingLot(2);
        Object vehicle = new Object();
        parkingLot.parkVehicle(vehicle);
        assertTrue(parkingLot.unParkVehicle(vehicle));
    }

    @Test
    public void shouldNotBeUnparkTheNotExistVehicle() {
        ParkingLot parkingLot = new ParkingLot(2);
        Object vehicle = new Object();
        Object newVehicle = new Object();
        parkingLot.parkVehicle(vehicle);
        assertFalse(parkingLot.unParkVehicle(newVehicle));
    }

    @Test
    public void checkUnparkTheSameVehicle() {
        ParkingLot parkingLot = new ParkingLot(1);
        Object vehicle = new Object();
        assertFalse(parkingLot.unParkVehicle(vehicle));
    }



}