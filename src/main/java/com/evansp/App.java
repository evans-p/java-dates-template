package com.evansp;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

/**
 * Main.
 */
@SuppressWarnings("unused")
public class App {
    /**
     * Main
     * @param args args
     */
    public static void main( String[] args)  {
        flightLandingDateTimeManagement();
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

    private static void instantManagement() {
        Instant instant = Instant.now();
        Instant greeceInstant = Instant.now(Clock.system(ZoneId.of("UTC+2")));

        System.out.println(greeceInstant);
        System.out.println(instant);
        System.out.println(instant.atZone(ZoneId.of("UTC+2")));
    }


    private static void flightLandingDateTimeManagement() {
        ZoneOffset originZone = ZoneOffset.of("+0");
        ZoneOffset destinationZone = ZoneOffset.of("+8");

        // DateTimes for local.
        LocalDateTime departure = LocalDateTime.now(originZone);
        LocalDateTime arrival = departure.plusHours(17L).plusMinutes(55L);

        System.out.println("Departure LocalDateTime: " + departure);
        System.out.println("Arrival LocalDateTime: " + arrival);

        OffsetDateTime departureOriginZone = OffsetDateTime.of(departure, originZone);
        OffsetDateTime departureDestinationZone = departureOriginZone.withOffsetSameInstant(destinationZone);

        System.out.println("departureOriginZone: " + departureOriginZone);
        System.out.println("departureDestinationZone: " + departureDestinationZone);

        OffsetDateTime arrivalOriginZone = OffsetDateTime.of(arrival, originZone);
        OffsetDateTime arrivalDestinationZone = arrivalOriginZone.withOffsetSameInstant(destinationZone);

        System.out.println("arrivalOriginZone: " + arrivalOriginZone);
        System.out.println("arrivalDestinationZone: " + arrivalDestinationZone);
    }
}
