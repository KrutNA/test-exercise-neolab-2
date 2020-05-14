package com.krutna.testexercise;

import java.util.stream.Stream;

/** Class which represents operations with time in String format */
public class TimeProcessor {
  private enum Time {
    HOURS(24),
    MINUTES(60),
    SECONDS(60);

    private final int value;

    public final int get() {
      return this.value;
    }

    Time(int value) {
      this.value = value;
    }
  }

  /**
   * This function correct time value like '8:70:70' to '09:11:10'
   *
   * @param time String which contains time in format '?:?:?' where '?' is an integer from 0 to 9999
   * @return String, corrected time in format '\d\d:\d\d:\d\d' or `time` if string is empty
   * @throws IllegalArgumentException if time is not in correct format
   */
  public String correct(String time) throws IllegalArgumentException {

    if (time.isEmpty()) return time;
    if (!time.matches("\\d{1,4}:\\d{1,4}:\\d{1,4}"))
      throw new IllegalArgumentException(
          "Expected time in format '?:?:?' where '?' is an integer from 0 to 9999.");

    final int[] values = Stream.of(time.split(":")).mapToInt(Integer::parseInt).toArray();

    values[1] = values[1] + values[2] / Time.SECONDS.get();
    values[2] = values[2] % Time.SECONDS.get();
    values[0] = (values[0] + values[1] / Time.MINUTES.get()) % Time.HOURS.get();
    values[1] = values[1] % Time.MINUTES.get();

    return String.format("%02d:%02d:%02d", values[0], values[1], values[2]);
  }
}
