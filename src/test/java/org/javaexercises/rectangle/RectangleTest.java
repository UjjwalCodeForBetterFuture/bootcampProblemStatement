package org.javaexercises.rectangle;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {

    @BeforeEach
    void setup() {

    }

    @Test
    public void area_of_Rectangle_Should_Be_25_len_5_And_bre_5() throws Exception {
        Rectangle rectangle = new Rectangle(5, 5);
        assertEquals(25, rectangle.area());
    }

    @Test
    public void area_of_Rectangle_Should_Be_Large_len_Inf_And_bre_Inf() throws Exception {
        Rectangle rectangle = new Rectangle(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Assertions.assertThrows(Exception.class, rectangle::area);
    }

    @Test
    public void perimeterOfRectangleShouldBe_len_5_bre_10_30() throws Exception {
        Rectangle rectangle = new Rectangle(5, 10);
        Assertions.assertEquals(30, rectangle.perimeter());
    }

    @Test
    public void perimeterForNegative() {
        Assertions.assertThrows(Exception.class, () -> new Rectangle(-1, -1));
    }

    @Test
    public void perimeterOfSquareShouldBe_20_len_5_bre_5() throws Exception {
        Rectangle rectangle = new Rectangle(5, 5);
        Assertions.assertEquals(20, rectangle.perimeter());
    }

    @Test
    public void areaOfSquareShouldBe_25_len_5_bre_5() throws Exception {
        Rectangle rectangle = new Rectangle(5, 5);
        Assertions.assertEquals(25, rectangle.area());
    }
}
