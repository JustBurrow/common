package kr.lul.common.util;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.time.*;
import java.time.temporal.ChronoUnit;

import static java.lang.Thread.sleep;
import static java.util.concurrent.ThreadLocalRandom.current;
import static kr.lul.common.util.AdjustableTimeProvider.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/11/04
 */
public class AdjustableTimeProviderTest {
  private static final Logger log = getLogger(AdjustableTimeProviderTest.class);

  private AdjustableTimeProvider provider;

  @Before
  public void setUp() throws Exception {
    this.provider = new AdjustableTimeProvider();
  }

  @Test
  public void test_fixed_with_epoch_seconds() throws Exception {
    // Given
    final Instant expected = Instant.now();
    log.debug("GIVEN - expected={}", expected);
    Option option = fixed(expected);
    this.provider.setOption(option);

    final long sleep = current().nextLong(1L, 1000L);
    sleep(sleep);

    // WHEN
    Instant actual = this.provider.now();
    log.debug("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .isNotNull()
        .isEqualTo(actual);
  }

  @Test
  public void test_fixed_with_zoned_date_time() throws Exception {
    // GIVEN
    Instant expected = Instant.ofEpochSecond(current().nextLong(MIN_SECOND, MAX_SECOND));
    final ZonedDateTime zdt = ZonedDateTime.ofInstant(expected, this.provider.zoneId());
    log.debug("GIVEN - expected={}, zdt={}", expected, zdt);

    Option option = AdjustableTimeProvider.fixed(zdt);
    this.provider.setOption(option);
    log.debug("GIVEN - option={}", option);

    sleep(current().nextLong(1000L, 3000L));

    // WHEN
    Instant actual = this.provider.now();
    log.debug("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .isNotNull()
        .isNotSameAs(expected)
        .isEqualTo(expected);
  }

  @Test
  public void test_fixed_with_local_date_time() throws Exception {
    // GIVEN
    Instant expected = Instant.ofEpochSecond(current().nextLong(MIN_SECOND, MAX_SECOND));
    LocalDateTime ldt = LocalDateTime.ofInstant(expected, this.provider.zoneId());
    log.debug("GIVEN - expected={}, ldt={}", expected, ldt);

    Option option = fixed(ldt);
    this.provider.setOption(option);
    log.debug("GIVEN - option={}", option);

    // WHEN
    Instant actual = this.provider.now();
    log.debug("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .isNotNull()
        .isNotSameAs(expected)
        .isEqualTo(expected);
  }

  @Test
  public void test_diff_seconds() throws Exception {
    // GIVEN
    final long diff = current().nextLong(MIN_SECOND, MAX_SECOND + 1L);
    log.debug("GIVEN - diff={}", diff);
    Option option = AdjustableTimeProvider.diff(diff);
    this.provider.setOption(option);
    log.debug("GIVEN - option={}", option);

    Instant base = Instant.now();
    long sleep = current().nextLong(1000L, 2000L);
    log.debug("GIVEN - base={}, sleep={}ms", base, sleep);

    // WHEN
    Instant actual = this.provider.now();
    log.debug("WHEN - actual={}", actual);

    // THEN
    long second = actual.getEpochSecond();
    assertThat(actual)
        .isNotNull();
    assertThat(second)
        .isEqualTo(base.getEpochSecond() + diff);
  }

  @Test
  public void test_diff_duration() throws Exception {
    // GIVEN
    long seconds = current().nextLong(-1000L, 1000L);
    Duration duration = Duration.of(seconds, ChronoUnit.SECONDS);
    log.debug("GIVEN - seconds={}, duration={}", seconds, duration);

    Option option = AdjustableTimeProvider.diff(duration);
    this.provider.setOption(option);
    log.debug("GIVEN - option={}", option);

    long sleep = current().nextLong(1000L, 2000L);
    Instant base = Instant.now();
    log.debug("GIVEN - base={}, sleep={}ms", base, sleep);

    // WHEN
    Instant actual = this.provider.now();
    log.debug("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .isNotNull();
    assertThat(actual.getEpochSecond())
        .isEqualTo(base.getEpochSecond() + seconds);
  }

  @Test
  public void test_diff_period() throws Exception {
    // GIVEN
    int year = current().nextInt(-100, 100);
    int month = current().nextInt(-24, 24);
    int day = current().nextInt(-60, 60);
    Period period = Period.of(year, month, day);
    log.debug("GIVEN - period={}, year={}, month={}, day={}", period, year, month, day);

    Option option = diff(period);
    this.provider.setOption(option);
    log.debug("GIVEN - option={}", option);

    ZonedDateTime expected = ZonedDateTime.now();
    log.debug("GIVEN - expected={}", expected);

    // WHEN
    Instant actual = this.provider.now();
    log.debug("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .isNotNull()
        .isNotSameAs(expected);
    assertThat(actual.getEpochSecond())
        .isEqualTo(expected.plusYears(year).plusMonths(month).plusDays(day).toEpochSecond());
  }
}
