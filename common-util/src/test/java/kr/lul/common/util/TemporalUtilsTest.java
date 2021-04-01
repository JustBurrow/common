package kr.lul.common.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
        .isEqualTo(Instant.ofEpochMilli(this.instant.toEpochMilli() + 1L).getNano());
  }

  @Test
  void test_millisecondPrecision_with_0_cut() {
    // GIVEN
    Instant instant = Instant.now().with(NANO_OF_SECOND, 123_000_000L);
    LOGGER.info("[GIVEN] instant={}", instant);

    // WHEN
    Instant actual = millisecondsPrecision(instant);
    LOGGER.info("[WHEN] actual={}", actual);

    // THEN
    assertThat(actual.toEpochMilli())
        .isEqualTo(instant.toEpochMilli());
    assertThat(actual.getNano() % 1_000_000L)
        .isZero();
  }

  @Test
  @DisplayName("2021-04-02T13:31:50.028826Z -> 2021-04-02T13:31:50.029Z")
  void test_millisecondPrecision_cases() {
    // GIVEN
    Instant instant = Instant.parse("2021-04-02T13:31:50.028826Z");
    LOGGER.info("[GIVEN] instant={}", instant);

    // WHEN
    Instant actual = millisecondsPrecision(instant);
    LOGGER.info("[WHEN] actual={}", actual);

    // THEN
    assertThat(actual.getEpochSecond())
        .isEqualTo(instant.getEpochSecond());
    assertThat(actual.getNano())
        .isEqualTo(29_000_000L);
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
        .isEqualTo((this.instant.getNano() / 1000L + 1L) * 1000L);
  }

  @Test
  void test_microPrecision_with_0_cut() {
    // GIVEN
    Instant instant = Instant.now().with(NANO_OF_SECOND, 123_456_000L);
    LOGGER.info("[GIVEN] instant={}", instant);

    // WHEN
    Instant actual = microPrecision(instant);
    LOGGER.info("[WHEN] actual={}", actual);

    // THEN
    assertThat(actual.getEpochSecond())
        .isEqualTo(instant.getEpochSecond());
    assertThat(actual.getNano())
        .isEqualTo(instant.getNano());
    assertThat(actual.getNano() % 1000L)
        .isZero();
  }
}
