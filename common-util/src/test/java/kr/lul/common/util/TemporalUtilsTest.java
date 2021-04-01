package kr.lul.common.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.time.Instant;

import static java.time.temporal.ChronoField.NANO_OF_SECOND;
import static kr.lul.common.util.TemporalUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2021/04/01
 */
class TemporalUtilsTest {
  private static final Logger LOGGER = getLogger(TemporalUtilsTest.class);

  private Instant instant;

  @BeforeEach
  void setUp() {
    this.instant = Instant.now().with(NANO_OF_SECOND, 123_456_789L);
    LOGGER.info("[SETUP] instant={}", this.instant);
  }

  @Test
  void test_secondPrecision_with_null() {
    assertThatThrownBy(() -> secondPrecision(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("instant is null.");
  }

  @Test
  void test_secondPrecision() {
    // WHEN
    Instant actual = secondPrecision(this.instant);
    LOGGER.info("[WHEN] actual={}", actual);

    // THEN
    assertThat(actual)
        .isNotNull()
        .isNotEqualTo(this.instant);
    assertThat(actual.getEpochSecond())
        .isEqualTo(this.instant.getEpochSecond());
    assertThat(actual.getNano())
        .isEqualTo(0L);
  }

  @Test
  void test_millisecondsPrecision_with_null() {
    assertThatThrownBy(() -> millisecondsPrecision(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("instant is null.");
  }

  @Test
  void test_millisecondPrecision() {
    // WHEN
    Instant actual = millisecondsPrecision(this.instant);
    LOGGER.info("[WHEN] actual={}", actual);

    // THEN
    assertThat(actual)
        .isNotEqualTo(this.instant);
    assertThat(actual.getEpochSecond())
        .isEqualTo(this.instant.getEpochSecond());
    assertThat(actual.getNano())
        .isLessThanOrEqualTo(this.instant.getNano())
        .isEqualTo(Instant.ofEpochMilli(this.instant.toEpochMilli()).getNano());
  }

  @Test
  void test_microPrecision_with_null() {
    assertThatThrownBy(() -> microPrecision(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("instant is null.");
  }

  @Test
  void test_microPrecision() {
    // WHEN
    Instant actual = microPrecision(this.instant);
    LOGGER.info("[WHEN] actual={}", actual);

    // THEN
    assertThat(actual)
        .isNotNull()
        .isNotEqualTo(this.instant);
    assertThat(actual.getEpochSecond())
        .isEqualTo(this.instant.getEpochSecond());
    assertThat(actual.getNano())
        .isEqualTo((this.instant.getNano() / 1000L) * 1000L);
  }
}
