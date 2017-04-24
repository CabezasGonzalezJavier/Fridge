package com.thedeveloperworldisyours.fridge;

/**
 * Created by javierg on 24/04/2017.
 */

public class Customer {

    private final String name;
    private final int numberOfKindersToGrab;

    public Customer(String name, int numberOfKindersToGrab) {
        this.name = name;
        this.numberOfKindersToGrab = numberOfKindersToGrab;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfKindersToGrab() {
        return numberOfKindersToGrab;
    }

    @Override
    public String toString() {
        return "Customer{"
                + "name='" + name + '\''
                + ", numberOfKindersToGrab=" + numberOfKindersToGrab
                + '}';
    }
}
