package org.javaexercises.measurement;

import java.util.Objects;

import static org.javaexercises.Constant.DIVIDEND;
import static org.javaexercises.Constant.MULTIPLICATION;

public class Measurement {

    private final double quantity;
    private final Unit unit;

    public Measurement(double quantity, Unit unit) {
        this.quantity = quantity;
        this.unit = unit;
    }

    public static Measurement kilogram(double quantity) {
        return new Measurement(quantity, Unit.KILOGRAM);
    }

    public static Measurement gram(double quantity) {
        return new Measurement(quantity, Unit.GRAM);
    }

    public static Measurement milligram(double quantity) {
        return new Measurement(quantity, Unit.MILLIGRAM);
    }

    public static Measurement kilometer(double quantity) {
        return new Measurement(quantity, Unit.KILOMETERS);
    }

    public static Measurement meter(double quantity) {
        return new Measurement(quantity, Unit.METER);
    }

    public static Measurement centimeter(double quantity) {
        return new Measurement(quantity, Unit.CENTIMETER);

    }

    public Measurement add(Measurement measurement) {
        return convert(this, measurement.unit.getConvertedMeasurementByOperator(measurement.quantity, MULTIPLICATION) + this.unit.getConvertedMeasurementByOperator(this.quantity, MULTIPLICATION));
    }

    private Measurement convert(Measurement measurement, double result) {
        return new Measurement(measurement.unit.getConvertedMeasurementByOperator(result, DIVIDEND), measurement.unit);
    }

    @Override
    public boolean equals(Object distanceReff) {
        if (this == distanceReff) return true;
        if (!(distanceReff instanceof Measurement)) return false;
        Measurement distanceRef = (Measurement) distanceReff;
        return distanceRef.unit.getConvertedMeasurementByOperator(distanceRef.quantity, MULTIPLICATION) == unit.getConvertedMeasurementByOperator(quantity, MULTIPLICATION) && unit.getMeasurementType() == distanceRef.unit.getMeasurementType();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(unit.getConvertedMeasurementByOperator(quantity, MULTIPLICATION));
    }
}
