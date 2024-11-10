package com.evansp;

import java.time.LocalDateTime;

/**
 * Work Period, with start time and end time
 */
public class WorkPeriod {
  /**
   * Start Date time.
   */
  private final LocalDateTime start;

  /**
   * End Date time.
   */
  private final LocalDateTime end;

  /**
   * Private Constructor.
   *
   * @param start {@link LocalDateTime}.
   * @param end {@link LocalDateTime}.
   */
  private WorkPeriod(LocalDateTime start, LocalDateTime end) {
    this.start = start;
    this.end = end;
  }

  public static WorkPeriod of(LocalDateTime start, LocalDateTime end) {
    return new WorkPeriod(start, end);
  }


}
