package com;

/**
 * Triangle utility class
 */
public class Triangle {

    /**
     * Determines if three sides can form a triangle
     * 
     * @param a side length a
     * @param b side length b
     * @param c side length c
     * @return true if it can form a triangle, false otherwise
     */
    public static boolean isTriangle(int a, int b, int c) {
        return a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a;
    }

    /**
     * Gets the triangle type
     * 
     * @param a side length a
     * @param b side length b
     * @param c side length c
     * @return triangle type
     */
    public static String getTriangleType(int a, int b, int c) {
        if (!isTriangle(a, b, c)) {
            return "Not a triangle";
        }

        if (a == b && b == c) {
            return "Equilateral triangle";
        } else if (a == b || b == c || a == c) {
            return "Isosceles triangle";
        } else {
            return "Scalene triangle";
        }
    }
}