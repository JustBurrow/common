package kr.lul.common.util;

import org.junit.Test;
import org.slf4j.Logger;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2020/05/20
 */
public class AbbreviateNumberFormatTest {
  private static final Logger log = getLogger(AbbreviateNumberFormatTest.class);

  @Test
  public void test_decimal() throws Exception {
    // GIVEN
    final AbbreviateNumberFormat.Unit kilo = new AbbreviateNumberFormat.Unit("K", 1_000L);
    final AbbreviateNumberFormat.Unit mega = new AbbreviateNumberFormat.Unit("M", 1_000_000L);
    final AbbreviateNumberFormat.Unit giga = new AbbreviateNumberFormat.Unit("G", 1_000_000_000L);
    final AbbreviateNumberFormat.Unit tera = new AbbreviateNumberFormat.Unit("T", 1_000_000_000_000L);
    final AbbreviateNumberFormat.Unit peta = new AbbreviateNumberFormat.Unit("P", 1_000_000_000_000_000L);
    final AbbreviateNumberFormat.Unit exa = new AbbreviateNumberFormat.Unit("E", 1_000_000_000_000_000_000L);
    log.info("GIVEN - kilo={}, mega={}, giga={}, tera={}, peta={}, exa={}", kilo, mega, giga, tera, peta, exa);

    // WHEN
    final AbbreviateNumberFormat format = new AbbreviateNumberFormat(exa, mega, giga, kilo, tera, peta);
    log.info("WHEN - format={}", format);

    // THEN
    assertThat(format.getUnits())
        .containsExactly(exa, peta, tera, giga, mega, kilo);
    assertThat(of(format.abbreviate(1_234L), format.abbreviate(12_345L), format.abbreviate(123_456L),
        format.abbreviate(-1_234L), format.abbreviate(-12_345L), format.abbreviate(-123_456L)))
        .containsSequence("1K", "12K", "123K",
            "-1K", "-12K", "-123K");
    assertThat(of(format.abbreviate(1_234_567L), format.abbreviate(12_345_678L),
        format.abbreviate(123_456_789L), format.abbreviate(-1_234_567L),
        format.abbreviate(-12_345_678L), format.abbreviate(-123_456_789L)))
        .containsSequence("1M", "12M",
            "123M", "-1M",
            "-12M", "-123M");
    assertThat(format.abbreviate(1_234_567_890L))
        .isEqualTo("1G");
    assertThat(format.abbreviate(1_234_567_890_123L))
        .isEqualTo("1T");
    assertThat(format.abbreviate(1_234_567_890_123_456L))
        .isEqualTo("1P");
    assertThat(format.abbreviate(1_234_567_890_123_456_789L))
        .isEqualTo("1E");
    assertThat(format.abbreviate(Integer.MIN_VALUE))
        .isEqualTo("-2G");
    assertThat(format.abbreviate(Integer.MAX_VALUE))
        .isEqualTo("2G");
    assertThat(format.abbreviate(Long.MIN_VALUE))
        .isEqualTo("-9E");
    assertThat(format.abbreviate(Long.MAX_VALUE))
        .isEqualTo("9E");
  }

  @Test
  public void test_binary() throws Exception {
    // GIVEN
    final long k = 1024L;
    final long m = 1024L * k;
    final long g = 1024L * m;
    final long t = 1024L * g;
    final long p = 1024L * t;
    final long e = 1024L * p;
    final AbbreviateNumberFormat.Unit kilo = new AbbreviateNumberFormat.Unit("K", k);
    final AbbreviateNumberFormat.Unit mega = new AbbreviateNumberFormat.Unit("M", m);
    final AbbreviateNumberFormat.Unit giga = new AbbreviateNumberFormat.Unit("G", g);
    final AbbreviateNumberFormat.Unit tera = new AbbreviateNumberFormat.Unit("T", t);
    final AbbreviateNumberFormat.Unit peta = new AbbreviateNumberFormat.Unit("P", p);
    final AbbreviateNumberFormat.Unit exa = new AbbreviateNumberFormat.Unit("E", e);
    log.info("GIVEN - kilo={}, mega={}, giga={}, tera={}, peta={}, exa={}", kilo, mega, giga, tera, peta, exa);

    // WHEN
    final AbbreviateNumberFormat format = new AbbreviateNumberFormat(exa, mega, giga, kilo, tera, peta);
    log.info("WHEN - format={}", format);

    // THEN
    assertThat(of(format.abbreviate(1024L), format.abbreviate(12 * 1024L), format.abbreviate(123 * 1024L),
        format.abbreviate(-1024L), format.abbreviate(-12 * 1024L), format.abbreviate(-123 * 1024L)))
        .containsSequence("1K", "12K", "123K",
            "-1K", "-12K", "-123K");
    assertThat(of(format.abbreviate(m), format.abbreviate(12 * m), format.abbreviate(123 * m),
        format.abbreviate(-1 * m), format.abbreviate(-12 * m), format.abbreviate(-123 * m)))
        .containsSequence("1M", "12M", "123M",
            "-1M", "-12M", "-123M");
    assertThat(of(format.abbreviate(Integer.MIN_VALUE), format.abbreviate(Integer.MAX_VALUE),
        format.abbreviate(Long.MIN_VALUE), format.abbreviate(Long.MAX_VALUE)))
        .containsSequence("-2G", "1G", "-8E", "7E");
  }
}
