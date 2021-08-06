package org.javaexercises.distance;

public enum ConversionFactor {

    KILOMETERS(1000000), METER(1000), CENTIMETER(10), MILLIMETER(1);

    ConversionFactor(Integer conversionFactor) {
        this.conversionFactor = conversionFactor;
    }
    public final Integer conversionFactor;
}
