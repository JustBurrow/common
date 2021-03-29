package kr.lul.common.util;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static java.util.concurrent.ThreadLocalRandom.current;
import static kr.lul.common.util.Texts.*;
import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
    final String actual = singleQuote(null);
    log.debug("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .isNull();
  }

  @Test
  public void test_single_quote_with_empty() throws Exception {
    // WHEN
    final String actual = singleQuote("");
    log.debug("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .isEqualTo("''");
  }

  @Test
  public void test_single_quote_with_random() throws Exception {
    // GIVEN
    final String expected = random(current().nextInt(1, 10));
    log.debug("GIVEN - expected={}", expected);

    // WHEN
    final String actual = singleQuote(expected);
    log.debug("WHEN - actual={}", actual);

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
    final String actual = doubleQuote(null);
    log.debug("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .isNull();
  }

  @Test
  public void test_double_quote_with_empty() throws Exception {
    // WHEN
    final String actual = doubleQuote("");
    log.debug("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .isEqualTo("\"\"");
  }

  @Test
  public void test_double_quote_with_random() throws Exception {
    // GIVEN
    final String expected = random(current().nextInt(1, 100));
    log.debug("GIVEN - expected={}", expected);

    // WHEN
    final String actual = doubleQuote(expected);
    log.debug("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .contains(expected)
        .hasSize(expected.length() + 2)
        .startsWith("\"")
        .endsWith("\"");
  }

  @Test
  public void test_head_with_null() throws Exception {
    assertThat(head(null, 10))
        .isNull();
  }

  @Test
  public void test_head_with_0_max() throws Exception {
    assertThatThrownBy(() -> head("abc", 0, false))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("too small max.");
  }

  @Test
  public void test_head_with_1_max_and_ellipsis() throws Exception {
    assertThatThrownBy(() -> head("abc", 1, true))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("too small max.");
  }

  @Test
  public void test_head_with_same_max_and_ellipsis() throws Exception {
    assertThat(head("abcd", 4))
        .isEqualTo("abcd");
  }

  @Test
  public void test_head_with_large_max() throws Exception {
    // GIVEN
    final String text = "abcd";
    final int max = text.length() + 1;
    log.info("GIVEN - text={}, max={}", text, max);

    // WHEN
    final String head = head(text, max);
    log.info("WHEN - head={}", head);

    // THEN
    assertThat(head)
        .hasSize(text.length())
        .isEqualTo(text);
  }

  @Test
  public void test_head_with_ellipsis() throws Exception {
    // GIVEN
    final String text = "abcd";
    final int max = text.length() - 1;
    log.info("GIVEN - text={}, max={}", text, max);

    // WHEN
    final String head = head(text, max);
    log.info("WHEN - head={}", head);

    // THEN
    assertThat(head)
        .hasSize(max)
        .isEqualTo("ab…");
  }

  @Test
  public void test_head_without_ellipsis() throws Exception {
    // GIVEN
    final String text = "abcd";
    final int max = text.length() - 1;
    log.info("GIVEN - text={}, max={}", text, max);

    // WHEN
    final String head = head(text, max, false);
    log.info("WHEN - head={}", head);

    // THEN
    assertThat(head)
        .hasSize(max)
        .isEqualTo("abc");
  }
}
