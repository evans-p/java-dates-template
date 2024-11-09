package com.evansp;

import java.time.Duration;
import java.time.Period;

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
        periodManagement();
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

    /**
     * sample usage of {@link Period}.
     */
    private static void periodManagement() {
        Period period = Period.ofYears(1);

        System.out.println(period); // P1Y
        System.out.println(period.plusMonths(2)); // P1Y2M
        System.out.println(period); // P1Y
    }
}
