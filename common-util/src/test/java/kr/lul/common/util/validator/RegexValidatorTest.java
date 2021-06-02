package kr.lul.common.util.validator;

import kr.lul.common.util.ValidationException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.MULTILINE;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2020/01/05
 */
public class RegexValidatorTest {
  private static final Logger LOGGER = getLogger(RegexValidatorTest.class);

  @Test
  public void test_validate_case_insensitive() throws Exception {
    // GIVEN
    final RegexValidator validator = new RegexValidator("target", "[a-z]+", Pattern.CASE_INSENSITIVE);
    LOGGER.info("GIVEN - validator={}", validator);

    String la = "a";
    String ua = "A";
    LOGGER.info("[GIVEN] la={}, ua={}", la, ua);

    // WHEN
    String actual1 = validator.validate(la);
    String actual2 = validator.validate(ua);
    LOGGER.info("[WHEN] actual1={}, actual2={}", actual1, actual2);

    // THEN
    assertThat(actual1)
        .isSameAs(la);
    assertThat(actual2)
        .isSameAs(ua);
  }

  @Test
  public void test_validate_case_sensitive() throws Exception {
    // GIVEN
    final RegexValidator validator = new RegexValidator("target", "[a-z]+");
    LOGGER.info("GIVEN - validator={}", validator);

    // WHEN
    final ValidationException ex = catchThrowableOfType(() -> validator.validate("A"), ValidationException.class);
    LOGGER.info("WHEN - ex=" + ex, ex);

    // THEN
    assertThat(ex)
        .isNotNull()
        .hasMessageStartingWith("illegal target pattern : target='A'");
  }

  @Test
  public void test_validate_multi_line() throws Exception {
    // GIVEN
    final RegexValidator validator = new RegexValidator("target", "\\S+", MULTILINE);
    LOGGER.info("GIVEN - validator={}", validator);

    // WHEN
    final ValidationException ex = catchThrowableOfType(
        () -> validator.validate(randomAlphanumeric(1, 10) + "\n" + randomAlphanumeric(1, 10)),
        ValidationException.class);
    LOGGER.info("WHEN - ex=" + ex, ex);

    // THEN
    assertThat(ex)
        .isNotNull()
        .hasMessageStartingWith("illegal target pattern");
  }
}
