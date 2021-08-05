package org.javaexercises.cabby;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CabRideTest {
    @Test
    public void cabFareShouldBe_30_For_3_KmTravelled() {
        CabRide cabRide = new CabRide(3);
        assertEquals(30, cabRide.fare());
    }

    @Test
    public void cabFareShouldBe_20_For_2_KmTravelled() {
        CabRide cabRide = new CabRide(2);
        assertEquals(20, cabRide.fareForDistanceTravelled());
    }
}
