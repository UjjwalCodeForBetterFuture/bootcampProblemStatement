package org.javaexercises.distance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.javaexercises.distance.Distance.*;
import static org.junit.jupiter.api.Assertions.*;

public class DistanceTest {

    @Test
    public void thousandMetersShouldEqualThousandMeters() {
        assertEquals(meter(1000), meter(1000));
    }


    @Test
    public void fortyKilometersShouldEqual40Kilometer() {
        assertEquals(kilometer(40), kilometer(40));
    }

    @Test
    public void thousandMeterShouldEqualOneKilometer() {
        assertEquals(kilometer(1), meter(1000));
    }

    @Test
    public void thousandMeterShouldNotEqualTwoKilometer() {
        assertNotEquals(kilometer(2), meter(1000));
    }

    @Test
    public void oneMeterShouldNotEqualTwoMeters() {
        assertNotEquals(meter(2), meter(1));
    }

    @Test
    public void hundredsCMShouldBeEqualToOneMeter() {
        assertEquals(meter(1), centimeter(100));
    }

    @Test
    public void hundredsCMShouldNotBeEqualToOneKiloMeter() {
        assertNotEquals(meter(1), kilometer(1));
    }

    @Test
    public void hashCodeShouldBeSameForOneKmAndThousandMeters() {
        assertEquals(kilometer(1).hashCode(), meter(1000).hashCode());
    }

}
