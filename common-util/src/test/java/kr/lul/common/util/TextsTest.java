package kr.lul.common.util;

import org.junit.Test;
import org.slf4j.Logger;

import static java.util.concurrent.ThreadLocalRandom.current;
import static kr.lul.common.util.Texts.doubleQuote;
import static kr.lul.common.util.Texts.singleQuote;
import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/11/04
 */
public class TextsTest {
  private static final Logger log = getLogger(TextsTest.class);

  @Test
  public void test_single_quote_with_null() throws Exception {
    // WHEN
    String actual = singleQuote(null);
    log.info("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .isNull();
  }

  @Test
  public void test_single_quote_with_empty() throws Exception {
    // WHEN
    String actual = singleQuote("");
    log.info("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .isEqualTo("''");
  }

  @Test
  public void test_single_quote_with_random() throws Exception {
    // GIVEN
    String expected = random(current().nextInt(1, 10));
    log.info("GIVEN - expected={}", expected);

    // WHEN
    String actual = singleQuote(expected);
    log.info("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .contains(expected)
        .startsWith("'")
        .endsWith("'")
        .hasSize(expected.length() + 2);
  }

  @Test
  public void test_double_quote_with_null() throws Exception {
    // WHEN
    String actual = doubleQuote(null);
    log.info("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .isNull();
  }

  @Test
  public void test_double_quote_with_empty() throws Exception {
    // WHEN
    String actual = doubleQuote("");
    log.info("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .isEqualTo("\"\"");
  }

  @Test
  public void test_double_quote_with_random() throws Exception {
    // GIVEN
    String expected = random(current().nextInt(1, 100));
    log.info("GIVEN - expected={}", expected);

    // WHEN
    String actual = doubleQuote(expected);
    log.info("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .contains(expected)
        .hasSize(expected.length() + 2)
        .startsWith("\"")
        .endsWith("\"");
  }
}
