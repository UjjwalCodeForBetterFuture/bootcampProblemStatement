package org.javaexercises.measurement;

import static org.javaexercises.Constant.*;

public enum Unit {

    KILOMETERS(100000, DISTANCE), METER(100, DISTANCE), CENTIMETER(1, DISTANCE),
    KILOGRAM(1000000, MASS), GRAM(1000, MASS), MILLIGRAM(1, MASS);

    private final double conversionFactor;
    private final String measurementType;

    Unit(Integer conversionFactor, String measurementType) {
        this.conversionFactor = conversionFactor;
        this.measurementType = measurementType;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public double getConvertedMeasurementByOperator(double measurement, String operator) {
        return operator == MULTIPLICATION ? measurement * conversionFactor : measurement / conversionFactor;
    }
}
