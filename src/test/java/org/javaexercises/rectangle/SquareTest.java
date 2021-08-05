package org.javaexercises.rectangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTest {
    @Test
    public void perimeterOfSquareShouldBe_20_len_5() throws Exception {
        Square square = new Square(5);
        Assertions.assertEquals(20, square.perimeter());
    }

    @Test
    public void areaOfSquareShouldBe_25_len_5() throws Exception {
        Square square = new Square(5);
        Assertions.assertEquals(25, square.area());
    }
}
