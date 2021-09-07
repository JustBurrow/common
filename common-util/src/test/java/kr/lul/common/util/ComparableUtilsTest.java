package kr.lul.common.util;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

import static java.time.Instant.now;
import static kr.lul.common.util.ComparableUtils.max;
import static kr.lul.common.util.ComparableUtils.min;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2021/09/07
 */
class ComparableUtilsTest {
  private static final Logger LOGGER = getLogger(ComparableUtilsTest.class);
  private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

  @SuppressWarnings({ "ConstantConditions", "ConfusingArgumentToVarargsMethod" })
  @Test
  void test_max_with_null() {
    assertThatThrownBy(() -> max(null, null))
        .isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> max(null, null, null))
        .isInstanceOf(NullPointerException.class);
  }

  @Test
  void test_max_with_ints() {
    // WHEN
    int m1 = max(0, 1);
    int m2 = max(0, 1, 2);
    int m3 = max(0, 1, 2, 3);

    // THEN
    assertThat(m1)
        .isEqualTo(1);
    assertThat(m2)
        .isEqualTo(2);
    assertThat(m3)
        .isEqualTo(3);
  }

  @Test
  void test_max_with_longs() {
    // WHEN
    long m1 = max(0, 1);
    long m2 = max(0, 1, 2);
    long m3 = max(0, 1, 2, 3);

    // THEN
    assertThat(m1)
        .isEqualTo(1);
    assertThat(m2)
        .isEqualTo(2);
    assertThat(m3)
        .isEqualTo(3);
  }

  @Test
  void test_max_with_2_instants() {
    // GIVEN
    final Instant i0 = now();
    final Instant i1 = now().plusMillis(1L);
    LOGGER.info("[GIVEN] i0={}, i1={}", i0, i1);

    // WHEN
    Instant max = max(i0, i1);
    LOGGER.info("[WHEN] max={}", max);

    // THEN
    assertThat(max)
        .isEqualTo(i1);
  }

  @Test
  void test_max_with_instants() {
    // GIVEN
    final Instant i0 = now();
    final Instant i1 = now().plusMillis(1L);
    final Instant i2 = now().plusMillis(2L);
    final Instant i3 = now().plusMillis(3L);

    // WHEN
    Instant m1 = max(i0, i1);
    Instant m2 = max(i0, i1, i2);
    Instant m3 = max(i0, i1, i2, i3);

    // THEN
    assertThat(m1)
        .isEqualTo(i1);
    assertThat(m2)
        .isEqualTo(i2);
    assertThat(m3)
        .isEqualTo(i3);
  }

  @Test
  void test_min_with_ints() {
    // WHEN
    int m1 = min(4, 3);
    int m2 = min(4, 2, 3);
    int m3 = min(4, 2, 3, 1);

    // THEN
    assertThat(m1)
        .isEqualTo(3);
    assertThat(m2)
        .isEqualTo(2);
    assertThat(m3)
        .isEqualTo(1);
  }

  @Test
  void test_min_with_longs() {
    // WHEN
    long m1 = min(1L, 0L);
    long m2 = min(1L, -1L, 0L);
    long m3 = min(1L, -1L, 0L, 3L);

    // THEN
    assertThat(m1)
        .isEqualTo(0L);
    assertThat(m2)
        .isEqualTo(-1L);
    assertThat(m3)
        .isEqualTo(-1L);
  }

  @Test
  void test_min_with_instants() {
    // GIVEN
    final Instant i0 = now();
    final Instant i1 = now().plusMillis(1L);
    final Instant i2 = now().plusMillis(2L);
    final Instant i3 = now().plusMillis(3L);

    // WHEN
    Instant m1 = min(i1, i3);
    Instant m2 = min(i2, i1, i3);
    Instant m3 = min(i2, i1, i3, i0);

    // THEN
    assertThat(m1)
        .isEqualTo(i1);
    assertThat(m2)
        .isEqualTo(i1);
    assertThat(m3)
        .isEqualTo(i0);
  }
}