package org.javaexercises.distance;

public enum Unit {

    KILOMETERS(1000000), METER(1000), CENTIMETER(10);

    private final Integer conversionFactor;

    Unit(Integer conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public int getConvertedDistance(int distance) {
        return distance * conversionFactor;
    }
}
