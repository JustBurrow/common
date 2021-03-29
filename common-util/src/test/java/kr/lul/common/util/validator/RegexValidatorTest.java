package kr.lul.common.util.validator;

import kr.lul.common.util.ValidationException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.MULTILINE;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2020/01/05
 */
public class RegexValidatorTest {
  private static final Logger log = getLogger(RegexValidatorTest.class);

  @Test
  public void test_validate_case_insensitive() throws Exception {
    // GIVEN
    final RegexValidator validator = new RegexValidator("target", "[a-z]+", Pattern.CASE_INSENSITIVE);
    log.info("GIVEN - validator={}", validator);

    // WHEN
    validator.validate("a");
    validator.validate("A");

    // THEN
    log.info("THEN - OK");
  }

  @Test
  public void test_validate_case_sensitive() throws Exception {
    // GIVEN
    final RegexValidator validator = new RegexValidator("target", "[a-z]+");
    log.info("GIVEN - validator={}", validator);

    // WHEN
    validator.validate("a");
    final ValidationException ex = catchThrowableOfType(() -> validator.validate("A"), ValidationException.class);
    log.info("WHEN - ex=" + ex, ex);

    // THEN
    assertThat(ex)
        .isNotNull()
        .hasMessageStartingWith("illegal target pattern : target='A'");
  }

  @Test
  public void test_validate_multi_line() throws Exception {
    // GIVEN
    final RegexValidator validator = new RegexValidator("target", "\\S+", MULTILINE);
    log.info("GIVEN - validator={}", validator);

    // WHEN
    validator.validate(randomAlphabetic(1, 10));
    final ValidationException ex = catchThrowableOfType(
        () -> validator.validate(randomAlphanumeric(1, 10) + "\n" + randomAlphanumeric(1, 10)),
        ValidationException.class);
    log.info("WHEN - ex=" + ex, ex);

    // THEN
    assertThat(ex)
        .isNotNull()
        .hasMessageStartingWith("illegal target pattern");
  }
}
