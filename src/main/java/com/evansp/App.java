package com.evansp;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Main.
 */
public class App {
    /**
     * Main
     * @param args args
     */
    public static void main( String[] args)  {
        workPeriodsManagement();
    }

    private static void workPeriodsManagement() {
        LocalDate date = LocalDate.of(2024, Month.NOVEMBER, 11);
        WorkPeriod workPeriod = WorkPeriods.
            createMorningWorkPeriod(date);

        System.out.println(workPeriod);

        List<WorkPeriod> workPeriods = WorkPeriods.generateWorkPeriods(date, 10);
        System.out.println(workPeriods);
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

    private static void dateTimeManagement() {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("UTC+2"));

        ZonedDateTime greeceDateTime = localDateTime.atZone(ZoneId.of("UTC+2"));
        ZonedDateTime franceDateTime = greeceDateTime.withZoneSameInstant(ZoneId.of("UTC+1"));
        ZonedDateTime englandDateTime = greeceDateTime.withZoneSameInstant(ZoneId.of("UTC"));

        System.out.println("France: " + franceDateTime.toLocalDateTime());
        System.out.println("Greece: " + greeceDateTime.toLocalDateTime());
        System.out.println("England: " + englandDateTime.toLocalDateTime());
    }
}
