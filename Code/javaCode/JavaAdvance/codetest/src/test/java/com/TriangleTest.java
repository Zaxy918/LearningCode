package com;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * JUnit tests for Triangle class
 */
public class TriangleTest {

    @Before
    public void setUp() {
        System.out.println("Preparing to execute tests...");
    }

    @After
    public void tearDown() {
        System.out.println("Test execution completed");
    }

    @Test
    public void testValidTriangle() {
        assertTrue("3,4,5 should be a valid triangle", Triangle.isTriangle(3, 4, 5));
        assertTrue("5,12,13 should be a valid triangle", Triangle.isTriangle(5, 12, 13));
        assertTrue("1,1,1 should be a valid triangle", Triangle.isTriangle(1, 1, 1));
    }

    @Test
    public void testInvalidTriangle() {
        assertFalse("1,2,3 should not be a valid triangle", Triangle.isTriangle(1, 2, 3));
        assertFalse("1,1,3 should not be a valid triangle", Triangle.isTriangle(1, 1, 3));
        assertFalse("0,5,5 should not be a valid triangle", Triangle.isTriangle(0, 5, 5));
    }

    @Test
    public void testTriangleType() {
        assertEquals("Equilateral triangle", Triangle.getTriangleType(5, 5, 5));
        assertEquals("Isosceles triangle", Triangle.getTriangleType(5, 5, 8));
        assertEquals("Scalene triangle", Triangle.getTriangleType(3, 4, 5));
        assertEquals("Not a triangle", Triangle.getTriangleType(1, 2, 3));
    }

    @Test
    public void testEdgeCases() {
        assertFalse("Negative side length should not be a valid triangle", Triangle.isTriangle(-1, 2, 3));
        assertFalse("Zero side length should not be a valid triangle", Triangle.isTriangle(0, 0, 0));
    }
}