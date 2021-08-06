package org.javaexercises.distance;

import static org.javaexercises.Constant.MULTIPLICATION;

public enum Unit {

    KILOMETERS(100000), METER(100), CENTIMETER(1);

    private final double conversionFactor;

    Unit(Integer conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConvertedDistanceByOperator(double distance, String operator) {
        return operator == MULTIPLICATION ? distance * conversionFactor : distance / conversionFactor;
    }
}
