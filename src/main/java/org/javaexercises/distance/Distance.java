package org.javaexercises.distance;

import java.util.Objects;

import static org.javaexercises.Constant.DIVIDEND;
import static org.javaexercises.Constant.MULTIPLICATION;

public class Distance {

    private final double quantity;
    private final Unit unit;

    public Distance(double quantity, Unit unit) {
        this.quantity = quantity;
        this.unit = unit;
    }

    public static Distance kilometer(double quantity) {
        return new Distance(quantity, Unit.KILOMETERS);
    }

    public static Distance meter(double quantity) {
        return new Distance(quantity, Unit.METER);
    }

    public static Distance centimeter(double quantity) {
        return new Distance(quantity, Unit.CENTIMETER);

    }

    public Distance add(Distance distance) {
        return convert(this, distance.unit.getConvertedDistanceByOperator(distance.quantity, MULTIPLICATION) + this.unit.getConvertedDistanceByOperator(this.quantity, MULTIPLICATION));
    }

    private Distance convert(Distance distance, double result) {
        return new Distance(distance.unit.getConvertedDistanceByOperator(result, DIVIDEND), distance.unit);
    }

    @Override
    public boolean equals(Object distanceReff) {
        if (this == distanceReff) return true;
        if (!(distanceReff instanceof Distance)) return false;
        Distance distanceRef = (Distance) distanceReff;
        return distanceRef.unit.getConvertedDistanceByOperator(distanceRef.quantity, MULTIPLICATION) == unit.getConvertedDistanceByOperator(quantity, MULTIPLICATION);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(unit.getConvertedDistanceByOperator(quantity, MULTIPLICATION));
    }
}
