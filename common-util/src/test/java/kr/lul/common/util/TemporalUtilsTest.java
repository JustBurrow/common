package kr.lul.common.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.time.*;

import static java.time.temporal.ChronoField.NANO_OF_SECOND;
import static kr.lul.common.util.TemporalUtils.MICROSECONDS_ADJUSTER;
import static kr.lul.common.util.TemporalUtils.MILLISECONDS_ADJUSTER;
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
  public void setUp() {
    this.instant = Instant.now().with(NANO_OF_SECOND, 123_456_789L);
    LOGGER.info("[SETUP] instant={}", this.instant);
  }

  @Test
  public void test_MILLISECONDS_ADJUSTER_with_null() {
    assertThatThrownBy(() -> MILLISECONDS_ADJUSTER.adjustInto(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("temporal is null.");
  }

  @Test
  public void test_MILLISECONDS_ADJUSTER() {
    // GIVEN
    final Instant instant = Instant.now()
        .with(NANO_OF_SECOND, 123_456_789L);
    final ZonedDateTime zdt = ZonedDateTime.now()
        .with(NANO_OF_SECOND, 123_456_789L);
    final OffsetDateTime odt = OffsetDateTime.now()
        .with(NANO_OF_SECOND, 123_456_789L);
    final LocalDateTime ldt = LocalDateTime.now()
        .with(NANO_OF_SECOND, 123_456_789L);
    final LocalDate ld = LocalDate.now();
    final LocalTime lt = LocalTime.now()
        .with(NANO_OF_SECOND, 123_456_789L);
    LOGGER.info("[GIVEN] instant={}, zdt={}, odt={}, ldt={}, ld={}, lt={}",
        instant, zdt, odt, ldt, ld, lt);
    final long expected = 123_000_000L;

    // WHEN
    final Instant instant2 = MILLISECONDS_ADJUSTER.adjust(instant);
    final ZonedDateTime zdt2 = MILLISECONDS_ADJUSTER.adjust(zdt);
    final OffsetDateTime odt2 = MILLISECONDS_ADJUSTER.adjust(odt);
    final LocalDateTime ldt2 = MILLISECONDS_ADJUSTER.adjust(ldt);
    final LocalDate ld2 = MILLISECONDS_ADJUSTER.adjust(ld);
    final LocalTime lt2 = MILLISECONDS_ADJUSTER.adjust(lt);
    LOGGER.info("[GIVEN] instant2={}, zdt2={}, odt2={}, ldt2={}, ld2={}, lt2={}",
        instant2, zdt2, odt2, ldt2, ld2, lt2);

    // THEN
    assertThat(instant2)
        .isNotEqualTo(instant);
    assertThat(instant2.getEpochSecond()).isEqualTo(instant.getEpochSecond());
    assertThat(instant2.getNano()).isEqualTo(expected);

    assertThat(zdt2)
        .isNotEqualTo(zdt);
    assertThat(zdt2.getYear()).isEqualTo(zdt.getYear());
    assertThat(zdt2.getMonth()).isEqualTo(zdt.getMonth());
    assertThat(zdt2.getDayOfMonth()).isEqualTo(zdt.getDayOfMonth());
    assertThat(zdt2.getHour()).isEqualTo(zdt.getHour());
    assertThat(zdt2.getMinute()).isEqualTo(zdt.getMinute());
    assertThat(zdt2.getSecond()).isEqualTo(zdt.getSecond());
    assertThat(zdt2.getNano()).isEqualTo(expected);
    assertThat(zdt2.getZone()).isEqualTo(zdt.getZone());

    assertThat(odt2)
        .isNotEqualTo(odt);
    assertThat(odt2.getYear()).isEqualTo(odt.getYear());
    assertThat(odt2.getMonth()).isEqualTo(odt.getMonth());
    assertThat(odt2.getDayOfMonth()).isEqualTo(odt.getDayOfMonth());
    assertThat(odt2.getHour()).isEqualTo(odt.getHour());
    assertThat(odt2.getMinute()).isEqualTo(odt.getMinute());
    assertThat(odt2.getSecond()).isEqualTo(odt.getSecond());
    assertThat(odt2.getNano()).isEqualTo(expected);
    assertThat(odt2.getOffset()).isEqualTo(odt.getOffset());

    assertThat(ldt2)
        .isNotEqualTo(ldt);
    assertThat(ldt2.getYear()).isEqualTo(ldt.getYear());
    assertThat(ldt2.getMonth()).isEqualTo(ldt.getMonth());
    assertThat(ldt2.getDayOfMonth()).isEqualTo(ldt.getDayOfMonth());
    assertThat(ldt2.getHour()).isEqualTo(ldt.getHour());
    assertThat(ldt2.getMinute()).isEqualTo(ldt.getMinute());
    assertThat(ldt2.getSecond()).isEqualTo(ldt.getSecond());
    assertThat(ldt2.getNano()).isEqualTo(expected);

    assertThat(ld2).isEqualTo(ld);

    assertThat(lt2)
        .isNotEqualTo(lt);
    assertThat(lt2.getHour()).isEqualTo(lt.getHour());
    assertThat(lt2.getMinute()).isEqualTo(lt.getMinute());
    assertThat(lt2.getSecond()).isEqualTo(lt.getSecond());
    assertThat(lt2.getNano()).isEqualTo(expected);
  }

  @Test
  public void test_MICROSECONDS_ADJUSTER_with_null() {
    assertThatThrownBy(() -> MICROSECONDS_ADJUSTER.adjustInto(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("temporal is null.");
  }

  @Test
  public void test_MICROSECONDS_ADJUSTER() {
    // GIVEN
    final Instant instant = Instant.now()
        .with(NANO_OF_SECOND, 123_456_789L);
    final ZonedDateTime zdt = ZonedDateTime.now()
        .with(NANO_OF_SECOND, 123_456_789L);
    final OffsetDateTime odt = OffsetDateTime.now()
        .with(NANO_OF_SECOND, 123_456_789L);
    final LocalDateTime ldt = LocalDateTime.now()
        .with(NANO_OF_SECOND, 123_456_789L);
    final LocalDate ld = LocalDate.now();
    final LocalTime lt = LocalTime.now()
        .with(NANO_OF_SECOND, 123_456_789L);
    LOGGER.info("[GIVEN] instant={}, zdt={}, odt={}, ldt={}, ld={}, lt={}",
        instant, zdt, odt, ldt, ld, lt);
    final long expected = 123_456_000L;

    // WHEN
    final Instant instant2 = MICROSECONDS_ADJUSTER.adjust(instant);
    final ZonedDateTime zdt2 = MICROSECONDS_ADJUSTER.adjust(zdt);
    final OffsetDateTime odt2 = MICROSECONDS_ADJUSTER.adjust(odt);
    final LocalDateTime ldt2 = MICROSECONDS_ADJUSTER.adjust(ldt);
    final LocalDate ld2 = MICROSECONDS_ADJUSTER.adjust(ld);
    final LocalTime lt2 = MICROSECONDS_ADJUSTER.adjust(lt);
    LOGGER.info("[GIVEN] instant2={}, zdt2={}, odt2={}, ldt2={}, ld2={}, lt2={}",
        instant2, zdt2, odt2, ldt2, ld2, lt2);

    // THEN
    assertThat(instant2)
        .isNotEqualTo(instant);
    assertThat(instant2.getEpochSecond()).isEqualTo(instant.getEpochSecond());
    assertThat(instant2.getNano()).isEqualTo(expected);

    assertThat(zdt2)
        .isNotEqualTo(zdt);
    assertThat(zdt2.getYear()).isEqualTo(zdt.getYear());
    assertThat(zdt2.getMonth()).isEqualTo(zdt.getMonth());
    assertThat(zdt2.getDayOfMonth()).isEqualTo(zdt.getDayOfMonth());
    assertThat(zdt2.getHour()).isEqualTo(zdt.getHour());
    assertThat(zdt2.getMinute()).isEqualTo(zdt.getMinute());
    assertThat(zdt2.getSecond()).isEqualTo(zdt.getSecond());
    assertThat(zdt2.getNano()).isEqualTo(expected);
    assertThat(zdt2.getZone()).isEqualTo(zdt.getZone());

    assertThat(odt2)
        .isNotEqualTo(odt);
    assertThat(odt2.getYear()).isEqualTo(odt.getYear());
    assertThat(odt2.getMonth()).isEqualTo(odt.getMonth());
    assertThat(odt2.getDayOfMonth()).isEqualTo(odt.getDayOfMonth());
    assertThat(odt2.getHour()).isEqualTo(odt.getHour());
    assertThat(odt2.getMinute()).isEqualTo(odt.getMinute());
    assertThat(odt2.getSecond()).isEqualTo(odt.getSecond());
    assertThat(odt2.getNano()).isEqualTo(expected);
    assertThat(odt2.getOffset()).isEqualTo(odt.getOffset());

    assertThat(ldt2)
        .isNotEqualTo(ldt);
    assertThat(ldt2.getYear()).isEqualTo(ldt.getYear());
    assertThat(ldt2.getMonth()).isEqualTo(ldt.getMonth());
    assertThat(ldt2.getDayOfMonth()).isEqualTo(ldt.getDayOfMonth());
    assertThat(ldt2.getHour()).isEqualTo(ldt.getHour());
    assertThat(ldt2.getMinute()).isEqualTo(ldt.getMinute());
    assertThat(ldt2.getSecond()).isEqualTo(ldt.getSecond());
    assertThat(ldt2.getNano()).isEqualTo(expected);

    assertThat(ld2).isEqualTo(ld);

    assertThat(lt2)
        .isNotEqualTo(lt);
    assertThat(lt2.getHour()).isEqualTo(lt.getHour());
    assertThat(lt2.getMinute()).isEqualTo(lt.getMinute());
    assertThat(lt2.getSecond()).isEqualTo(lt.getSecond());
    assertThat(lt2.getNano()).isEqualTo(expected);
  }
}
