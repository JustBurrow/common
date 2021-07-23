package kr.lul.common.util;

import java.time.DateTimeException;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

import static java.time.temporal.ChronoField.NANO_OF_SECOND;
import static kr.lul.common.util.Arguments.notNull;

/**
 * {@link java.time}의 시각 정보 유틸리티.
 *
 * @author justburrow
 * @since 2021/04/01
 */
public abstract class TemporalUtils {
  /**
   * generic {@link TemporalAdjuster}.
   */
  public interface Adjuster extends TemporalAdjuster {
    @Override
    default Temporal adjustInto(Temporal temporal) {
      return adjust(temporal);
    }

    <T extends Temporal> T adjust(T temporal);
  }

  /**
   * milli second 단위까지만 남은 시각 정보를 반환한다.
   */
  public static final Adjuster MILLISECONDS_ADJUSTER = new Adjuster() {
    @Override
    public <T extends Temporal> T adjust(T temporal) {
      try {
        final long nano = notNull(temporal, "temporal")
            .getLong(NANO_OF_SECOND);
        final long cut = nano % 1_000_000L;
        //noinspection unchecked
        return (T) temporal.with(NANO_OF_SECOND, nano - cut);
      } catch (DateTimeException e) {
        return temporal;
      }
    }
  };

  /**
   * micro second 단위까지만 남은 시각 정보를 반환한다.
   */
  public static final Adjuster MICROSECONDS_ADJUSTER = new Adjuster() {
    @Override
    public <T extends Temporal> T adjust(T temporal) {
      try {
        final long nano = notNull(temporal, "temporal")
            .getLong(NANO_OF_SECOND);
        final long cut = nano % 1_000L;
        //noinspection unchecked
        return (T) temporal.with(NANO_OF_SECOND, nano - cut);
      } catch (DateTimeException e) {
        return temporal;
      }
    }
  };

  public TemporalUtils() {
    throw new UnsupportedOperationException();
  }
}
