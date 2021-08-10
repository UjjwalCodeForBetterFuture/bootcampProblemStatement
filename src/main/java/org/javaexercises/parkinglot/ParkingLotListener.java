package org.javaexercises.parkinglot;

public interface ParkingLotListener {
    ParkingLotListener NULL = new ParkingLotListener() {
        @Override
        public void notifyLotFull(ParkingLot parkingLot) {

        }

        @Override
        public void notifyWhenAvailable(ParkingLot parkingLot) {

        }
    };


    void notifyLotFull(ParkingLot parkingLot);

    void notifyWhenAvailable(ParkingLot parkingLot);
}
