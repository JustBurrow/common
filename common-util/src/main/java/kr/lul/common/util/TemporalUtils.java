package kr.lul.common.util;

import java.time.Instant;
import java.time.temporal.TemporalField;

import static kr.lul.common.util.Arguments.notNull;

/**
 * {@link java.time}의 시각 정보 유틸리티.
 *
 * @author justburrow
 * @since 2021/04/01
 * @deprecated {@link java.time.temporal.Temporal#with(TemporalField, long)}를 사용.
 */
@Deprecated
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
    final long sec = notNull(instant, "instant")
                         .getEpochSecond();
    final long n = instant.getNano();
    final long cut = n % 1_000_000L;

    final long nano = (0L == cut)
                          ? n
                          : n - cut + 1_000_000L;
    return Instant.ofEpochSecond(sec, nano);
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
    final long n = instant.getNano();
    final long cut = n % 1000L;

    final long nano = (0L == cut)
                          ? n
                          : n - cut + 1000L;

    return Instant.ofEpochSecond(sec, nano);
  }

  public TemporalUtils() {
    throw new UnsupportedOperationException();
  }
}
