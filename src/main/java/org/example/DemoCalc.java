package org.example;

public class DemoCalc {

    public int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }
}
