package kr.lul.common.util;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.time.temporal.ChronoUnit;
import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2021/08/01
 */
public class EnumUtilsTest {
  private static final Logger LOGGER = getLogger(EnumUtilsTest.class);

  @Test
  public void test_random_with_null() {
    assertThatThrownBy(() -> EnumUtils.random(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("type is null.");
  }

  @Test
  public void test_random() {
    // GIVEN
    final int count = 10_000_000;
    final double margin = 0.005;
    final Map<ChronoUnit, Integer> result = stream(ChronoUnit.values())
        .collect(toMap(unit -> unit, unit -> 0));
    LOGGER.info("[GIVEN] count={}, margin={}, result={}", count, margin, result);

    // WHEN
    for (int i = 0; i < count; i++) {
      ChronoUnit u = EnumUtils.random(ChronoUnit.class);
      int c = result.get(u);
      result.put(u, c + 1);
    }
    LOGGER.info("[WHEN] result={}", result);

    // THEN
    final int min = (int) ( ( ( 1 - margin ) * count ) / ChronoUnit.values().length );
    final int max = (int) ( ( ( 1 + margin ) * count ) / ChronoUnit.values().length );
    LOGGER.info("[THEN] min={}, max={}", min, max);
    result.forEach((u, c) -> {
      LOGGER.info("[THEN] u={}, c={}", u, c);
      assertThat(c)
          .isGreaterThanOrEqualTo(min)
          .isLessThanOrEqualTo(max);
    });
  }
}