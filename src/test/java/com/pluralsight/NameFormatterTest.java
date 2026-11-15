package com.pluralsight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameFormatterTest {

    @Test
    void testFirstAndLastName() {
        assertEquals("Johnson, Mel",
                NameFormatter.format("Mel", "Johnson"));
    }

    @Test
    void testAllNameComponents() {
        assertEquals("Johnson, Dr. Mel B, PhD",
                NameFormatter.format("Dr.", "Mel", "B", "Johnson", "PhD"));
    }

    @Test
    void testOptionalComponents() {
        assertEquals("Johnson, Mel",
                NameFormatter.format("", "Mel", "", "Johnson", ""));
    }

    @Test
    void testFullName() {
        assertEquals("Johnson, Dr. Mel B, PhD",
                NameFormatter.format("Dr. Mel B Johnson, PhD"));
    }

    @Test
    void testSimpleFullName() {
        assertEquals("Johnson, Mel",
                NameFormatter.format("Mel Johnson"));
    }
}
