package org.javaexercises.distance;

import java.util.Objects;

public class Distance {

    private final int quantity;
    private final Unit unit;

    public Distance(int quantity, Unit unit) {
        this.quantity = quantity;
        this.unit = unit;
    }

    public static Distance kilometer(int quantity) {
        return new Distance(quantity, Unit.KILOMETERS);
    }

    public static Distance meter(int quantity) {
        return new Distance(quantity, Unit.METER);
    }

    public static Distance centimeter(int quantity) {
        return new Distance(quantity, Unit.CENTIMETER);

    }

    @Override
    public boolean equals(Object distanceReff) {
        if (this == distanceReff) return true;
        if (!(distanceReff instanceof Distance)) return false;
        Distance distanceRef = (Distance) distanceReff;
        return distanceRef.unit.getConvertedDistance(distanceRef.quantity) == unit.getConvertedDistance(quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(unit.getConvertedDistance(quantity));
    }
}
