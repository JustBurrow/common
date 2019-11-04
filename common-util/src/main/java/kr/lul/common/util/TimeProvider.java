package kr.lul.common.util;

import java.time.*;

/**
 * 시스템의 {@link Clock}에 영향을 주거나 받지 않고 시각 정보에 접근하기 위한 인터페이스.
 *
 * @author justburrow
 * @since 2019/11/04
 */
public interface TimeProvider {
  /**
   * 기준 시간대.
   * 시간대에 의존적인 기능을 사용하기 위한 기반 기능.
   *
   * @return 시간대 ID.
   */
  ZoneId zoneId();

  /**
   * @return 기준 시간대의 {@link ZoneOffset}.
   */
  default ZoneOffset zoneOffset() {
    return zoneId().getRules().getOffset(now());
  }

  /**
   * 나노세컨드 정밀도의 현재 시각.
   *
   * @return 현재시각.
   */
  Instant now();

  /**
   * @return 기준 시간대의 현재 {@link ZonedDateTime}.
   */
  default ZonedDateTime zonedDateTime() {
    return now().atZone(zoneId());
  }

  /**
   * @return 기준 시간대의 현재 {@link OffsetDateTime}.
   */
  default OffsetDateTime offsetDateTime() {
    return OffsetDateTime.ofInstant(now(), zoneId());
  }

  /**
   * @return 기준 시간대의 현재 {@link OffsetTime}.
   */
  default OffsetTime offsetTime() {
    return OffsetTime.ofInstant(now(), zoneId());
  }

  /**
   * @return 기준 시간대의 현재 {@link LocalDateTime}.
   */
  default LocalDateTime localDateTime() {
    return LocalDateTime.ofInstant(now(), zoneId());
  }

  /**
   * @return 기준 시간대의 현재 {@link LocalDate}.
   */
  default LocalDate localDate() {
    return LocalDate.ofInstant(now(), zoneId());
  }

  /**
   * @return 기준 시간대의 현재 {@link LocalTime}.
   */
  default LocalTime localTime() {
    return LocalTime.ofInstant(now(), zoneId());
  }

  default ZonedDateTime zonedDateTime(Instant instant) {
    return ZonedDateTime.ofInstant(instant, zoneId());
  }
}
