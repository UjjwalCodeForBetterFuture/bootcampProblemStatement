package org.javaexercises.parkinglottest;

import org.javaexercises.parkinglot.Attendant;
import org.javaexercises.parkinglot.Listener;
import org.javaexercises.parkinglot.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParkingLotTest {
    Listener listener = new DummyParkingLotOwner();

    @Test
    public void checkParkingAvailableWith10Slots() {
        ParkingLot parkingLot = new ParkingLot(10, listener);
        assertTrue(parkingLot.parkVehicle(new Object()));

    }

    @Test
    public void checkParkingAvailableWithExistingVehicle() {
        ParkingLot parkingLot = new ParkingLot(1, listener);
        parkingLot.parkVehicle(new Object());
        assertFalse(parkingLot.parkVehicle(new Object()));
    }

    @Test
    public void shouldNotBeAbleToUnparkFromEmptyParkingLot() {
        ParkingLot parkingLot = new ParkingLot(0, listener);
        assertFalse(parkingLot.unParkVehicle(new Object()));
    }

    @Test
    public void shouldBeUnparkAVehicle() {
        ParkingLot parkingLot = new ParkingLot(2, listener);
        Object vehicle = new Object();
        parkingLot.parkVehicle(vehicle);
        assertTrue(parkingLot.unParkVehicle(vehicle));
    }

    @Test
    public void shouldNotBeUnparkTheNotExistVehicle() {
        ParkingLot parkingLot = new ParkingLot(2, listener);
        Object vehicle = new Object();
        Object newVehicle = new Object();
        parkingLot.parkVehicle(vehicle);
        assertFalse(parkingLot.unParkVehicle(newVehicle));
    }

    @Test
    public void checkUnparkTheSameVehicle() {
        ParkingLot parkingLot = new ParkingLot(1, listener);
        Object vehicle = new Object();
        assertFalse(parkingLot.unParkVehicle(vehicle));
    }

    @Test
    public void notifyOwnerForParkingFull() {
        DummyParkingLotOwner notification = new DummyParkingLotOwner();
        ParkingLot parkingLot = new ParkingLot(1, notification);
        Object vehicle = new Object();
        parkingLot.parkVehicle(vehicle);
        assertTrue(notification.wasNotified);
    }

    @Test
    public void donotNotifyOwnerForParkingFull() {
        DummyParkingLotOwner notification = new DummyParkingLotOwner();
        ParkingLot parkingLot = new ParkingLot(5, notification);
        Object vehicle = new Object();
        parkingLot.parkVehicle(vehicle);
        assertFalse(notification.wasNotified);
    }

    @Test
    public void shouldNotifyOnUnparkWhenLotWasPreviouslyFull() {
        DummyParkingLotOwner notification = new DummyParkingLotOwner();
        ParkingLot parkingLot = new ParkingLot(2, notification);
        Object vehicle = new Object();
        parkingLot.parkVehicle(vehicle);
        parkingLot.parkVehicle(new Object());
        parkingLot.unParkVehicle(vehicle);
        assertTrue(notification.wasNotifiedWhenAvailable);
    }

    @Test
    public void shouldNotNotifyOnUnparkIfLotWasNotPreviouslyFull() {
        DummyParkingLotOwner notification = new DummyParkingLotOwner();
        ParkingLot parkingLot = new ParkingLot(3, notification);
        Object vehicle = new Object();
        parkingLot.parkVehicle(vehicle);
        parkingLot.unParkVehicle(vehicle);
        assertFalse(notification.wasNotifiedWhenAvailable);
    }




    private static class DummyParkingLotOwner implements Listener {
        @Override
        public void notifyLotFull() {
            wasNotified = true;
        }

        @Override
        public void notifyWhenAvailable() {
            wasNotifiedWhenAvailable = true;
        }

        public boolean wasNotifiedWhenAvailable;

        public boolean wasNotified;
    }

}