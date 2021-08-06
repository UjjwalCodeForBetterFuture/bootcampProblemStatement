package org.javaexercises.distance;

import java.util.HashMap;

public enum DistanceEnum {

    KILOMETERS("kilometer", 1000), METER("meter", 1);

    private final String units;
    private final Integer conversion;

    DistanceEnum(String units, Integer conversion) {
        this.units = units;
        this.conversion = conversion;
    }

    static HashMap<String, Integer> distances = new HashMap<>();

    static {
        for (DistanceEnum distanceEnum : DistanceEnum.values()) {
            distances.put(distanceEnum.units, distanceEnum.conversion);
        }
    }

    public static Integer getDistanceValueInMeter(String unit) {
        return distances.get(unit);
    }

}
