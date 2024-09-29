package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DemoCalcTest {

    private final DemoCalc demoCalc = new DemoCalc();

    @Test
    public void testGetRandomNumberInRange() {
        int min = 1;
        int max = 10;
        int randomNumber = demoCalc.getRandomNumber(min, max);

        // Check that the random number is within the expected range
        assertTrue(randomNumber >= min && randomNumber < max,
                "Random number should be between " + min + " and " + max);
    }
//
//    @Test
//    public void testGetRandomNumberWithNegativeRange() {
//        int min = -10;
//        int max = -1;
//        int randomNumber = demoCalc.getRandomNumber(min, max);
//
//        // Check that the random number is within the expected negative range
//        assertTrue(randomNumber >= min && randomNumber < max,
//                "Random number should be between " + min + " and " + max);
//    }
//
//    @Test
//    public void testGetRandomNumberWithZeroRange() {
//        int min = 0;
//        int max = 1;
//        int randomNumber = demoCalc.getRandomNumber(min, max);
//
//        // Check that the random number is 0 since 0 <= random < 1
//        assertTrue(randomNumber == 0, "Random number should be 0");
//    }
}
