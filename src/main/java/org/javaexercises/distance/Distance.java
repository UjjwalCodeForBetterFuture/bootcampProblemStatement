package org.javaexercises.distance;

public class Distance {

    private final int quantity;
    private final String unit;

    public Distance(int quantity, String unit) {
        this.quantity = quantity;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object distanceReff) {
        Distance distanceRef = (Distance) distanceReff;
        Integer distance1 = distanceRef.quantity * DistanceEnum.getDistanceValueInMeter(distanceRef.unit);
        Integer distance2 = quantity * DistanceEnum.getDistanceValueInMeter(unit);
        return distance1.equals(distance2);
    }
}
