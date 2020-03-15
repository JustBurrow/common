package kr.lul.common.util;

import static kr.lul.common.util.Arguments.notNull;

/**
 * {@link java.lang.Math} 일부기능을 대체.
 *
 * @author justburrow
 * @since 2020/03/15
 */
public abstract class Maths {
  /**
   * @param input 입력.
   *
   * @return 최소값.
   *
   * @see java.lang.Math#min(int, int)
   */
  public static int min(final int... input) {
    notNull(input, "input");
    int min = Integer.MAX_VALUE;
    for (final int i : input) {
      if (min > i)
        min = i;
    }
    return min;
  }

  /**
   * @param input 입력.
   *
   * @return 최소값.
   *
   * @see java.lang.Math#min(long, long)
   */
  public static long min(final long... input) {
    notNull(input, "input");
    long min = Long.MAX_VALUE;
    for (final long l : input) {
      if (min > l)
        min = l;
    }
    return min;
  }

  /**
   * @param input 입력.
   *
   * @return 최소값.
   *
   * @see java.lang.Math#min(float, float)
   */
  public static float min(final float... input) {
    notNull(input, "input");
    float min = Float.MAX_VALUE;
    for (final float f : input) {
      if (min > f)
        min = f;
    }
    return min;
  }

  /**
   * @param input 입력.
   *
   * @return 최소값.
   *
   * @see java.lang.Math#min(double, double)
   */
  public static double min(final double... input) {
    notNull(input, "input");
    double min = Double.MAX_VALUE;
    for (final double d : input) {
      if (min > d)
        min = d;
    }
    return min;
  }

  /**
   * @param input 입력
   *
   * @return 입력값 중 최대값.
   *
   * @see Math#max(int, int)
   */
  public static int max(final int... input) {
    notNull(input, "input");

    int max = Integer.MIN_VALUE;
    for (final int i : input) {
      if (max < i)
        max = i;
    }
    return max;
  }

  /**
   * @param input 입력
   *
   * @return 입력값 중 최대값.
   *
   * @see Math#max(long, long)
   */
  public static long max(final long... input) {
    notNull(input, "input");

    long max = Long.MIN_VALUE;
    for (final long i : input) {
      if (max < i)
        max = i;
    }
    return max;
  }

  /**
   * @param input 입력
   *
   * @return 입력값 중 최대값.
   *
   * @see Math#max(float, float)
   */
  public static float max(final float... input) {
    notNull(input, "input");

    float max = Float.MIN_VALUE;
    for (final float i : input) {
      if (max < i)
        max = i;
    }
    return max;
  }

  /**
   * @param input 입력
   *
   * @return 입력값 중 최대값.
   *
   * @see Math#max(double, double)
   */
  public static double max(final double... input) {
    notNull(input, "input");

    double max = Double.MIN_VALUE;
    for (final double i : input) {
      if (max < i)
        max = i;
    }
    return max;
  }

  protected Maths() {
    throw new UnsupportedOperationException();
  }
}
