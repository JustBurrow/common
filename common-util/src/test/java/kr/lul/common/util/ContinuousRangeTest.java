package kr.lul.common.util;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static java.util.concurrent.ThreadLocalRandom.current;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/11/16
 */
public class ContinuousRangeTest {
  private static final Logger log = getLogger(ContinuousRangeTest.class);

  @Test
  public void test_new_with_lower_bound_greater_than_upper_bound() throws Exception {
    assertThatThrownBy(() -> new ContinuousRange<>(1, true, 0, true))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageStartingWith("upper bound is less than lower bound")
        .hasMessageContaining("lowerBound=1")
        .hasMessageContaining("upperBound=0");
  }

  @Test
  public void test_new_with_0_and_inclusive_and_0_inclusive() throws Exception {
    // WHEN
    ContinuousRange<Integer> range = new ContinuousRange<>(0, true, 0, true);
    log.info("WHEN - range={}", range);

    // THEN
    assertThat(range)
        .extracting(ContinuousRange::getLowerBound, ContinuousRange::isIncludeLowerBound,
            ContinuousRange::getUpperBound, ContinuousRange::isIncludeUpperBound,
            ContinuousRange::toString)
        .containsSequence(0, true, 0, true, "[0,0]");
    assertThat(range.isInclude(0))
        .isTrue();
    assertThat(range.isInclude(-1))
        .isFalse();
    assertThat(range.isInclude(1))
        .isFalse();

    assertThatThrownBy(() -> range.isInclude(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("comparee is null.");
  }

  @Test
  public void test_new_with_lower_bound_and_upper_bound() throws Exception {
    int lowerBound = 0;
    log.info("GIVEN - lowerBound={}", lowerBound);
    int upperBound = 1;
    log.info("GIVEN - upperBound={}", upperBound);

    // WHEN
    ContinuousRange<Integer> range = new ContinuousRange<>(lowerBound, upperBound);
    log.info("WHEN - range={}", range);

    // THEN
    assertThat(range)
        .extracting(ContinuousRange::getLowerBound, ContinuousRange::isIncludeLowerBound,
            ContinuousRange::getUpperBound, ContinuousRange::isIncludeUpperBound,
            ContinuousRange::toString)
        .containsSequence(lowerBound, true, upperBound, false, "[" + lowerBound + "," + upperBound + ")");
    assertThat(range.isInclude(lowerBound))
        .isTrue();
    assertThat(range.isInclude(lowerBound - 1))
        .isFalse();
    assertThat(range.isInclude(upperBound))
        .isFalse();
    assertThat(range.isInclude(upperBound + 1))
        .isFalse();

    assertThatThrownBy(() -> range.isInclude(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("comparee is null.");
  }

  @Test
  public void test_new_with_0_lower_bound_and_exclude_and_1_upper_bound_and_exclude() throws Exception {
    // WHEN
    ContinuousRange<Integer> range = new ContinuousRange<>(0, false, 1, false);
    log.info("WHEN - range={}", range);

    // THEN
    assertThat(range)
        .extracting(ContinuousRange::getLowerBound, ContinuousRange::isIncludeLowerBound,
            ContinuousRange::getUpperBound,
            ContinuousRange::isIncludeUpperBound, ContinuousRange::toString)
        .containsSequence(0, false, 1, false, "(0,1)");
    assertThat(range.isInclude(0))
        .isFalse();
    assertThat(range.isInclude(1))
        .isFalse();
  }

  @Test
  public void test_new_with_infinite_and_infinite() throws Exception {
    // WHEN
    ContinuousRange<Integer> range = new ContinuousRange<>();
    log.info("WHEN - range={}", range);

    // THEN
    assertThat(range)
        .extracting(ContinuousRange::getLowerBound, ContinuousRange::isIncludeLowerBound,
            ContinuousRange::getUpperBound, ContinuousRange::isIncludeUpperBound, ContinuousRange::toString)
        .containsSequence(null, false, null, false, "(-\u221E,\u221E)");
    assertThat(range.isInclude(Integer.MIN_VALUE))
        .as("Integer.MIN_VALUE=" + Integer.MIN_VALUE)
        .isTrue();
    assertThat(range.isInclude(Integer.MAX_VALUE))
        .as("Integer.MAX_VALUE=" + Integer.MAX_VALUE)
        .isTrue();
    for (int i = 0; i < 100; i++) {
      int comparee = current().nextInt();
      log.info("THEN - comparee={}", comparee);
      assertThat(range.isInclude(comparee))
          .isTrue();
    }
  }
}
