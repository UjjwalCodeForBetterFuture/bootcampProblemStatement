package org.javaexercises.distance;

public class Distance {

    private final int quantity;
    private final ConversionFactor unit;

    public Distance(int quantity, ConversionFactor unit) {
        this.quantity = quantity;
        this.unit = unit;
    }


    @Override
    public boolean equals(Object distanceReff) {
        if (this == distanceReff) return true;
        if (!(distanceReff instanceof Distance)) return false;
        Distance distanceRef = (Distance) distanceReff;
        Integer distance1 = distanceRef.quantity * distanceRef.unit.conversionFactor;
        Integer distance2 = quantity * unit.conversionFactor;
        return distance1.equals(distance2);
    }
}
