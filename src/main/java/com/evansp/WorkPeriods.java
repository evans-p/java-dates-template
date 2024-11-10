package com.evansp;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

public class WorkPeriods {

  public static final LocalTime MORNING_START_TIME = LocalTime.of(9, 0);
  public static final LocalTime AFTERNOON_START_TIME = LocalTime.of(18, 0);
  public static final Duration MORNING_WORK_PERIOD_LENGTH = Duration.ofHours(8);
  public static final Duration AFTERNOON_WORK_PERIOD_LENGTH = Duration.ofHours(4);
  private WorkPeriods() {
    // EMPTY
  }

  public static WorkPeriod createMorningWorkPeriod(LocalDate date) {

    LocalDateTime startDateTime = LocalDateTime.of(date, MORNING_START_TIME);
    LocalDateTime endDateTime =  startDateTime.plus(MORNING_WORK_PERIOD_LENGTH);

    return WorkPeriod.of(startDateTime, endDateTime);
  }

  public static WorkPeriod createAfternoonWorkPeriod(LocalDate date) {

    LocalDateTime startDateTime = LocalDateTime.of(date, AFTERNOON_START_TIME);
    LocalDateTime endDateTime =  startDateTime.plus(AFTERNOON_WORK_PERIOD_LENGTH);

    return WorkPeriod.of(startDateTime, endDateTime);
  }

  public static List<WorkPeriod> generateWorkPeriods(LocalDate date, int dayCount) {
    List<LocalDate> workDays = getWorkDays(date, dayCount);

    return workDays.stream()
        .map(d -> List.of(createMorningWorkPeriod(d), createAfternoonWorkPeriod(d)))
        .flatMap(List::stream)
        .toList();
  }

  private static List<LocalDate> getWorkDays(LocalDate date, int dayCount) {
    return Stream.iterate(date, (d)-> d.plusDays(1L))
        .filter(WorkPeriods::isWorkDay)
        .limit(dayCount)
        .toList();
  }

  private static boolean isWorkDay(LocalDate date) {
    return !(date.getDayOfWeek().equals(DayOfWeek.SATURDAY) ||
             date.getDayOfWeek().equals(DayOfWeek.SUNDAY));
  }
}
