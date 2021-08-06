package org.javaexercises.distance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DistanceTest {

    @Test
    public void thousandMetersShouldEqualThousandMeters() {
        Distance distance1000M = new Distance(1000, DistanceEnum.METER.name());
        Distance distance1000MCopy = new Distance(1000, DistanceEnum.METER.name());
        Assertions.assertTrue(distance1000M.equals(distance1000MCopy));
    }


    @Test
    public void distance_compare_kilometer_to_kilometer() {
        Distance distance40KM = new Distance(40, DistanceEnum.METER.name());
        Distance distance40KMCopy = new Distance(40, DistanceEnum.KILOMETERS.name());
        Assertions.assertTrue(distance40KM.equals(distance40KMCopy));
    }

    @Test
    public void distance_compare_metre_to_kilometer() {
        Distance distance1000M = new Distance(1000, DistanceEnum.METER.name());
        Distance distance1KM = new Distance(1, DistanceEnum.KILOMETERS.name());
        Assertions.assertTrue(distance1000M.equals(distance1KM));
    }

    @Test
    public void distance_compare_metre_to_kilometer_with_different_unit() {
        Distance distance1000M = new Distance(1000, DistanceEnum.METER.name());
        Distance distance2KM = new Distance(2, DistanceEnum.KILOMETERS.name());
        Assertions.assertFalse(distance1000M.equals(distance2KM));
    }

    @Test
    public void distance_compare_metre_to_meter_with_different_unit() {
        Distance distance1M = new Distance(1, DistanceEnum.METER.name());
        Distance distance2M = new Distance(2, DistanceEnum.METER.name());
        Assertions.assertFalse(distance1M.equals(distance2M));
    }

}
