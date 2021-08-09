package org.javaexercises.measurement;

import java.util.Objects;

import static org.javaexercises.Constant.DIVIDEND;
import static org.javaexercises.Constant.MULTIPLICATION;

public class Measurement {

    private final double value;
    private final Unit unit;

    public Measurement(double quantity, Unit unit) {
        this.value = quantity;
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

    public Measurement add(Measurement measurement) throws Exception {
        if (this.unit.isCompatibleWith(measurement.unit)) {
            return convert(this, measurement.unit.convert(measurement.value, MULTIPLICATION) + this.unit.convert(this.value, MULTIPLICATION));
        }
        throw new Exception("Both are not from same measurement");
    }

    private Measurement convert(Measurement measurement, double result) {
        return new Measurement(measurement.unit.convert(result, DIVIDEND), measurement.unit);
    }

    @Override
    public boolean equals(Object measurementReference) {
        if (this == measurementReference) return true;
        if (!(measurementReference instanceof Measurement)) return false;
        Measurement measurementReff = (Measurement) measurementReference;
        return measurementReff.unit.convert(measurementReff.value, MULTIPLICATION) == unit.convert(value, MULTIPLICATION) && this.unit.isCompatibleWith(measurementReff.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(unit.convert(value, MULTIPLICATION));
    }
}
