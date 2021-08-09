package org.javaexercises.measurement;

import org.junit.jupiter.api.Test;

import static org.javaexercises.measurement.Measurement.*;
import static org.junit.jupiter.api.Assertions.*;

public class MeasurementTest {

    @Test
    public void thousandMetersShouldEqualThousandMeters() {
        assertTrue(meter(1000).equals(meter(1000)));
    }


    @Test
    public void fortyKilometersShouldEqual40Kilometer() {
        assertTrue(kilometer(40).equals(kilometer(40)));
    }

    @Test
    public void thousandMeterShouldEqualOneKilometer() {
        assertTrue(kilometer(1).equals(meter(1000)));
    }

    @Test
    public void thousandMeterShouldNotEqualTwoKilometer() {
        assertFalse(kilometer(2).equals(meter(1000)));
    }

    @Test
    public void oneMeterShouldNotEqualTwoMeters() {
        assertFalse(meter(2).equals(meter(1)));
    }

    @Test
    public void hundredsCMShouldBeEqualToOneMeter() {
        assertTrue(meter(1).equals(centimeter(100)));
    }

    @Test
    public void hundredsCMShouldNotBeEqualToOneKiloMeter() {
        assertFalse(meter(1).equals(kilometer(1)));
    }

    @Test
    public void hashCodeShouldBeSameForOneKmAndThousandMeters() {
        assertFalse(kilometer(1).equals(meter(1000).hashCode()));
    }

    @Test
    public void addHundredMeterAndHundredMeterEquals200Meter() throws Exception {
        assertEquals(meter(200), meter(100).add(meter(100)));
    }

    @Test
    public void add1KMAndHundredMeterEquals1_2KM() throws Exception {
        assertEquals(kilometer(1.2).hashCode(), kilometer(1).add(meter(200)).hashCode());
    }

    @Test
    public void thousandGramShouldEqualThousandGram() {
        assertTrue(gram(1000).equals(gram(1000)));
    }


    @Test
    public void fortyKilogramShouldEqual40Kilogram() {
        assertTrue(kilogram(40).equals(kilogram(40)));
    }

    @Test
    public void thousandgramShouldEqualOneKilogram() {
        assertTrue(kilogram(1).equals(gram(1000)));
    }

    @Test
    public void thousandGramShouldNotEqualTwoKilogram() {
        assertFalse(kilogram(2).equals(gram(1000)));
    }

    @Test
    public void oneGramShouldNotEqualTwoThousandMiliGram() {
        assertFalse(gram(1).equals(milligram(2000)));
    }

    @Test
    public void oneGramShouldNotEqualOneCentimeter() {
        assertFalse(milligram(1).equals(centimeter(1)));
    }

    @Test
    public void shouldNotAddMassAndWeight() {
        assertThrows(Exception.class, () -> gram(100).add(kilogram(1.2)));
    }

    @Test
    public void addOneKiloGramAndHundredGramEquals200Gram() throws Exception {
        assertEquals(gram(1300), gram(100).add(kilogram(1.2)));
    }
}
