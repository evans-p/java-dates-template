package com.evansp;

import java.time.Duration;

/**
 * Main.
 */
public class App {
    /**
     * Main
     * @param args args
     */
    public static void main( String[] args)  {
        durationManagement();
    }

    /**
     * sample usage of {@link Duration}.
     */
    private static void durationManagement() {
        Duration duration = Duration.ofDays(1);

        System.out.println(duration); // PT24H
        System.out.println(duration.plus(Duration.ofDays(1))); // PT48H
        System.out.println(duration); // PT24H
    }
}
