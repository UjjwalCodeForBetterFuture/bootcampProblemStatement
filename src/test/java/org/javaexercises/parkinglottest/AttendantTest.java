package org.javaexercises.parkinglottest;

import org.javaexercises.parkinglot.Attendant;
import org.javaexercises.parkinglot.ParkingLot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AttendantTest {

    @Test
    public void attendantShouldBeAbleParkTheVehicleInFirstFreeSpace() throws Exception {
        //Arrange
        ParkingLot parkingLotA = new ParkingLot(3);
        ParkingLot parkingLotB = new ParkingLot(3);
        Attendant attendant = new Attendant(new ArrayList<ParkingLot>(Arrays.asList(parkingLotA, parkingLotB)));
        Object vehicle = new Object();
        //
        assertEquals(parkingLotA, attendant.parkVehicleInFreeParkingLot(vehicle));
    }

    @Test
    public void attendantShouldNotBeAbleParkTheVehicleIfParkingLotIsFull() throws Exception {
        ParkingLot parkingLotA = new ParkingLot(1);
        ParkingLot parkingLotB = new ParkingLot(1);
        Attendant attendant = new Attendant(new ArrayList<ParkingLot>(Arrays.asList(parkingLotA, parkingLotB)));
        Object vehicle = new Object();
        parkingLotA.parkVehicle(new Object());
        parkingLotB.parkVehicle(new Object());
        assertThrows(Exception.class,()-> attendant.parkVehicleInFreeParkingLot(vehicle));
    }

    @Test
    public void attendantShouldAbleToParkInSecondParkingSpaceIfFirstIsFull() throws Exception {
        ParkingLot parkingLotA = new ParkingLot(2);
        ParkingLot parkingLotB = new ParkingLot(4);
        parkingLotA.parkVehicle(new Object());
        parkingLotA.parkVehicle(new Object());
        parkingLotB.parkVehicle(new Object());
        Attendant attendant = new Attendant(new ArrayList<ParkingLot>(Arrays.asList(parkingLotA, parkingLotB)));
        Object vehicle = new Object();
        assertEquals(parkingLotB, attendant.parkVehicleInFreeParkingLot(vehicle));
    }

    @Test
    public void attendantShouldBeAbleToUnparkAVehicle() throws Exception {
        ParkingLot parkingLotA = new ParkingLot(3);
        ParkingLot parkingLotB = new ParkingLot(3);
        Attendant attendant = new Attendant(new ArrayList<ParkingLot>(Arrays.asList(parkingLotA, parkingLotB)));
        Object vehicle = new Object();
        ParkingLot parkingLot = attendant.parkVehicleInFreeParkingLot(vehicle);
        Assertions.assertTrue(attendant.unParkVehicleFromParkingLot(vehicle, parkingLot));
    }

    @Test
    public void attendantShouldNotBeAbleToUnparkAVehicleFromEmptyParking() throws Exception {
        ParkingLot parkingLotA = new ParkingLot(3);
        ParkingLot parkingLotB = new ParkingLot(3);
        Attendant attendant = new Attendant(new ArrayList<ParkingLot>(Arrays.asList(parkingLotA, parkingLotB)));
        Object vehicle = new Object();
        ParkingLot parkingLot = attendant.parkVehicleInFreeParkingLot(vehicle);
        Assertions.assertTrue(attendant.unParkVehicleFromParkingLot(vehicle, parkingLot));
    }
}
