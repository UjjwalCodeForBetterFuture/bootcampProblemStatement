package org.javaexercises.cabby;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CabRideTest {
    @Test
    public void cabFareShouldBe_30_For_3_KmTravelled_10_For_5_min() {
        CabRide cabRide = new CabRide(3, 5);
        assertEquals(30, cabRide.fareForDistanceTravelled());
        assertEquals(10, cabRide.fareForMin());
    }

    @Test
    public void cabFareShouldBe_20_For_2_KmTravelled() {
        CabRide cabRide = new CabRide(2);
        assertEquals(20, cabRide.fareForDistanceTravelled());
    }

    @Test
    public void cabFareShouldBe_8_For_4_min() {
        CabRide cabRide = new CabRide(0, 4);
        assertEquals(8, cabRide.fareForMin());
    }

    @Test
    public void totalCabFareShouldBe_410_FOR_40KM_5Min() {
        CabRide cabRide = new CabRide(40, 5);
        assertEquals(410, cabRide.totalCabFare());
    }
    @Test
    public void miniFareCheck() {
        CabRide cabRide = new CabRide(2, 1);
        assertEquals(40, cabRide.totalCabFare());
    }
}
