package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class UserServiceTest {

    private final UserService service = new UserService();

    @Test
    public void testGetUserAgeFromId_ReturnsCorrectAge() {
        String id = "123456199001011234"; // birth: 1990-01-01
        int expected = Period.between(LocalDate.of(1990, 1, 1), LocalDate.now()).getYears();
        assertEquals(expected, service.getUserAgeFromId(id));
    }

    @Test
    public void testGetUserAgeFromId_Null_Throws() {
        assertThrows(IllegalArgumentException.class, () -> service.getUserAgeFromId(null));
    }

    @Test
    public void testGetUserAgeFromId_InvalidLength_Throws() {
        assertThrows(IllegalArgumentException.class, () -> service.getUserAgeFromId("tooShort"));
    }

    @Test
    public void testGetUserAgeFromId_InvalidDate_Throws() {
        // substring for date is "19AA0101" which will fail to parse
        String id = "12345619AA01011234";
        assertThrows(DateTimeParseException.class, () -> service.getUserAgeFromId(id));
    }

    @Test
    public void testGetGenderFromId_Male() {
        // char at index 16 is '3' (odd) -> Male
        String id = "123456199001011234";
        assertEquals("Male", service.getGenderFromId(id));
    }

    @Test
    public void testGetGenderFromId_Female() {
        // char at index 16 is '2' (even) -> Female
        String id = "123456199001011224";
        assertEquals("Female", service.getGenderFromId(id));
    }

    @Test
    public void testGetGenderFromId_Null_Throws() {
        assertThrows(IllegalArgumentException.class, () -> service.getGenderFromId(null));
    }

    @Test
    public void testGetGenderFromId_InvalidLength_Throws() {
        assertThrows(IllegalArgumentException.class, () -> service.getGenderFromId("short"));
    }
}