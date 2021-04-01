package kr.lul.common.util;

import java.time.Instant;

import static kr.lul.common.util.Arguments.notNull;

/**
 * {@link java.time}의 시각 정보 유틸리티.
 *
 * @author justburrow
 * @since 2021/04/01
 */
public abstract class TemporalUtils {
  /**
   * 초 단위 미만을 버린다.
   *
   * @param instant 시각.
   *
   * @return 초 단위 정밀도로 조정한 시각.
   */
  public static Instant secondPrecision(Instant instant) {
    return Instant.ofEpochSecond(notNull(instant, "instant").getEpochSecond());
  }

  /**
   * 밀리초 단위 미만을 버린다.
   *
   * @param instant 시각.
   *
   * @return 밀리초 단위 정밀도로 조정한 시각.
   */
  public static Instant millisecondsPrecision(Instant instant) {
    return Instant.ofEpochMilli(
        notNull(instant, "instant").toEpochMilli());
  }

  /**
   * 마이크로 초 단위 미만을 버린다.
   *
   * @param instant 시각.
   *
   * @return 마이크로 초 단위 정밀도로 조정한 시각.
   */
  public static Instant microPrecision(Instant instant) {
    final long sec = notNull(instant, "instant")
                         .getEpochSecond();
    final long nano = instant.getNano() - instant.getNano() % 1000L;

    return Instant.ofEpochSecond(sec, nano);
  }

  public TemporalUtils() {
    throw new UnsupportedOperationException();
  }
}
