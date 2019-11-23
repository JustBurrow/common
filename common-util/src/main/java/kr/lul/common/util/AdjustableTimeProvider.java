package kr.lul.common.util;

import java.time.*;

import static java.lang.String.format;

/**
 * 시스템 시각을 기준으로 {@link java.time.Clock}에 영향을 주지 않고 설정에 따라 조정된 시각 정보를 제공한다.
 *
 * 만약 {@link java.time.Clock}이 제공하는 시각이 조작된다면 영향을 받는다.
 *
 * @author justburrow
 * @since 2019/11/04
 */
public class AdjustableTimeProvider implements TimeProvider {
  /**
   * {@link Instant} min epoch seconds.
   */
  public static final long MIN_SECOND = -31557014167219200L;
  /**
   * {@link Instant} max epoch seconds.
   */
  public static final long MAX_SECOND = 31556889864403199L;

  public static final ZoneId ZONE_ID = ZoneId.systemDefault();

  public interface Option {
    Instant adjustedInstant();
  }

  /**
   * 지정 시각으로 고정.
   *
   * @param instant 고정할 시각.
   *
   * @return 인작로 받은 시각으로 고정할 수 있는 옵션.
   */
  public static Option fixed(Instant instant) {
    return new Option() {
      @Override
      public Instant adjustedInstant() {
        return instant;
      }

      @Override
      public String toString() {
        return format("fixed : %s", instant);
      }
    };
  }

  public static Option fixed(ZonedDateTime zonedDateTime) {
    return new Option() {
      @Override
      public Instant adjustedInstant() {
        return zonedDateTime.toInstant();
      }

      @Override
      public String toString() {
        return format("fixed : %s", zonedDateTime);
      }
    };
  }

  public static Option fixed(LocalDateTime localDateTime) {
    return new Option() {
      @Override
      public Instant adjustedInstant() {
        return localDateTime.toInstant(ZONE_ID.getRules().getOffset(localDateTime));
      }

      @Override
      public String toString() {
        return format("fixed : %s", localDateTime);
      }
    };
  }

  /**
   * 시스템 시각에서 지정한 만큼 차이나도록 지정.
   *
   * @param seconds 초단위 차이.
   *
   * @return 지정한 시간만큼 차이를 낼 수 있는 옵션.
   */
  public static Option diff(final long seconds) {
    return new Option() {
      @Override
      public Instant adjustedInstant() {
        final Instant base = Instant.now();
        return Instant.ofEpochSecond(base.getEpochSecond() + seconds, base.getNano());
      }

      @Override
      public String toString() {
        return format("diff : %dseconds", seconds);
      }
    };
  }

  /**
   * 시스템 시각에서 지정한 시간({@link Duration})만큼 차이나도록 지정.
   *
   * @param duration 차이
   *
   * @return 지정한 시간만큼 차이를 낼 수 있는 옵션.
   */
  public static Option diff(Duration duration) {
    return new Option() {
      @Override
      public Instant adjustedInstant() {
        return (Instant) duration.addTo(Instant.now());
      }

      @Override
      public String toString() {
        return format("diff : %s", duration);
      }
    };
  }

  public static Option diff(Period period) {
    return new Option() {
      @Override
      public Instant adjustedInstant() {
        return ZonedDateTime.now().plus(period).toInstant();
      }

      @Override
      public String toString() {
        return format("diff : %s", period);
      }
    };
  }

  private Option option;

  public Option getOption() {
    return this.option;
  }

  public void setOption(Option option) {
    this.option = option;
  }

  @Override
  public ZoneId zoneId() {
    return ZONE_ID;
  }

  @Override
  public Instant now() {
    return null == this.option
        ? Instant.now()
        : this.option.adjustedInstant();
  }
}
