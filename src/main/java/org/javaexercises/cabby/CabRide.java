package org.javaexercises.cabby;

public class CabRide {
    private static final int FARE_PER_KM = 10;
    private static final int FARE_PER_MIN = 2;
    private final int distanceTravelled;
    private int timeWaited;

    public CabRide(int distanceTravelledInKm) {
        this.distanceTravelled = distanceTravelledInKm;
    }

    public CabRide(int distanceTravelledInKm, int timeWaited) {
        this.distanceTravelled = distanceTravelledInKm;
        this.timeWaited = timeWaited;
    }

    public int fareForMin() {
        return this.timeWaited * FARE_PER_MIN;
    }

    public int fareForDistanceTravelled() {
        return distanceTravelled * FARE_PER_KM;
    }

    public int totalCabFare() {
        return Math.max(fareForDistanceTravelled() + fareForMin(), 40);
    }
}
