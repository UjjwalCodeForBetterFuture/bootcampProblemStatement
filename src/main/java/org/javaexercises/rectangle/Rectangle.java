package org.javaexercises.rectangle;

public class Rectangle {
    private final int length;
    private final int breadth;

    public Rectangle(int length, int breadth) throws Exception {
        if (length <= 0 || breadth <= 0) {
            throw new Exception("length or breadth should not be negative or zero");
        }
        this.length = length;
        this.breadth = breadth;
    }

    public int area() {
        return Math.multiplyExact(length , breadth);
    }

    public int perimeter() {
        return 2 * (length + breadth);
    }
}
