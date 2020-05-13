package com.krutna.testexercise;

import java.util.Formatter;
import java.util.stream.Stream;

class TimeProcessor {
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

  public String correct(String time) {
    if (time.isEmpty()) return time;
    final int[] values = Stream.of(time.split(":")).mapToInt(Integer::parseInt).toArray();
    values[1] = values[1] + values[2] / Time.SECONDS.get();
    values[2] = values[2] % Time.SECONDS.get();
    values[0] = (values[0] + values[1] / Time.MINUTES.get()) % Time.HOURS.get();
    values[1] = values[1] % Time.MINUTES.get();

    Formatter formatter = new Formatter();
    String newTime = formatter.format("%02d:%02d:%02d", values[0], values[1], values[2]).toString();
    formatter.close();
    return newTime;
  }
}
