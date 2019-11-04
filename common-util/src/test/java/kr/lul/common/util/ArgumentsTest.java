package kr.lul.common.util;

import org.junit.Test;
import org.slf4j.Logger;

import static java.util.concurrent.ThreadLocalRandom.current;
import static kr.lul.common.util.Arguments.notNull;
import static kr.lul.common.util.Arguments.positive;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/11/04
 */
public class ArgumentsTest {
  private static final Logger log = getLogger(ArgumentsTest.class);

  @Test
  public void test_notNull_with_null() throws Exception {
    // WHEN
    assertThatThrownBy(() -> notNull(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasNoCause()
        .hasMessage("target is null.");
  }

  @Test
  public void test_notNull_with_object() throws Exception {
    notNull(new Object());
  }

  @Test
  public void test_notNull_with_null_and_name() throws Exception {
    // GIVEN
    String name = randomAlphabetic(10);
    log.info("GIVEN - name={}", name);

    // WHEN & THEN
    assertThatThrownBy(() -> notNull(null, name))
        .isInstanceOf(IllegalArgumentException.class)
        .hasNoCause()
        .hasMessage(name + " is null.");
  }

  @Test
  public void test_positive_with_0() throws Exception {
    // WHEN & THEN
    assertThatThrownBy(() -> positive(0))
        .isInstanceOf(IllegalArgumentException.class)
        .hasNoCause()
        .hasMessage("target is not positive : 0");
  }

  @Test
  public void test_positive_with_negative() throws Exception {
    // GIVEN
    int number = current().nextInt(Integer.MIN_VALUE, 0);
    log.info("GIVEN - number={}", number);

    // WHEN & THEN
    assertThatThrownBy(() -> positive(number))
        .isInstanceOf(IllegalArgumentException.class)
        .hasNoCause()
        .hasMessage("target is not positive : " + number);
  }

  @Test
  public void test_positive_with_1() throws Exception {
    positive(1);
  }

  @Test
  public void test_positive_with_positive() throws Exception {
    // GIVEN
    int number = current().nextInt(2, Integer.MAX_VALUE);
    log.info("GIVEN - number={}", number);

    // WHEN
    positive(number);
  }

  @Test
  public void test_positive_with_0L() throws Exception {
    // WHEN & THEN
    assertThatThrownBy(() -> positive(0L))
        .isInstanceOf(IllegalArgumentException.class)
        .hasNoCause()
        .hasMessage("target is not positive : 0");
  }

  @Test
  public void test_positive_with_negative_long() throws Exception {
    // GIVEN
    long number = current().nextLong(Long.MIN_VALUE, 0L);
    log.info("GIVEN - number={}", number);

    // WHEN & THEN
    assertThatThrownBy(() -> positive(number))
        .isInstanceOf(IllegalArgumentException.class)
        .hasNoCause()
        .hasMessage("target is not positive : " + number);
  }

  @Test
  public void test_positive_with_1L() throws Exception {
    positive(1L);
  }

  @Test
  public void test_positive_with_positive_long() throws Exception {
    // GIVEN
    long number = current().nextLong(2L, Long.MAX_VALUE);
    log.info("GIVEN - number={}", number);

    // WHEN
    positive(number);
  }
}
