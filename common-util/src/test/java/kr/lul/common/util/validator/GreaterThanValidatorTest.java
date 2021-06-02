package kr.lul.common.util.validator;

import kr.lul.common.util.ValidationException;
import kr.lul.common.util.Validator;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/11/16
 */
public class GreaterThanValidatorTest {
  private static final Logger LOGGER = getLogger(GreaterThanValidatorTest.class);

  @Test
  public void test_validate_with_newer_instant() throws Exception {
    // GIVEN
    Instant before = Instant.now();
    LOGGER.info("GIVEN - before={}", before);
    Validator<Instant> validator = new GreaterThanValidator<>("before", before);
    LOGGER.info("GIVEN - validator={}", validator);

    Instant target = before.plusNanos(1L);
    LOGGER.info("[GIVEN] target={}", target);

    // WHEN
    Instant actual = validator.validate(target);
    LOGGER.info("[WHEN] actual={}", actual);

    // THEN
    assertThat(actual)
        .isSameAs(target);
  }

  @Test
  public void test_validate_with_older_instant() throws Exception {
    // GIVEN
    Instant lowerBound = Instant.now();
    LOGGER.info("GIVEN - lowerBound={}", lowerBound);
    Validator<Instant> validator = new GreaterThanValidator<>("instant", lowerBound);
    LOGGER.info("GIVEN - validator={}", validator);
    Instant target = lowerBound.minusNanos(1L);
    LOGGER.info("GIVEN - target={}", target);

    // WHEN & THEN
    assertThatThrownBy(() -> validator.validate(target))
        .isInstanceOf(ValidationException.class)
        .hasMessageStartingWith("instant is not greater than lower bound")
        .hasMessageContaining("instant=" + target.toString())
        .hasMessageContaining("lowerBound=" + lowerBound.toString());
  }

  @Test
  public void test_validate_with_same_instant() throws Exception {
    // GIVEN
    Instant lowerBound = Instant.now();
    LOGGER.info("GIVEN - lowerBound={}", lowerBound);
    Validator<Instant> validator = new GreaterThanValidator<>("instant", lowerBound);
    LOGGER.info("GIVEN - validator={}", validator);

    // WHEN & THEN
    assertThatThrownBy(() -> validator.validate(lowerBound))
        .isInstanceOf(ValidationException.class)
        .hasMessageStartingWith("instant is not greater than lower bound")
        .hasMessageContaining("instant=" + lowerBound.toString())
        .hasMessageContaining("lowerBound=" + lowerBound.toString());
  }

  @Test
  public void test_validate_with_equal_instant() throws Exception {
    // GIVEN
    Instant lowerBound = Instant.now();
    LOGGER.info("GIVEN - lowerBound={}", lowerBound);
    Validator<Instant> validator = new GreaterThanValidator<>("instant", lowerBound);
    LOGGER.info("GIVEN - validator={}", validator);
    Instant target = Instant.ofEpochSecond(lowerBound.getEpochSecond(), lowerBound.getNano());
    LOGGER.info("GIVEN - target={}", target);

    // WHEN & THEN
    assertThatThrownBy(() -> validator.validate(target))
        .isInstanceOf(ValidationException.class)
        .hasMessageStartingWith("instant is not greater than lower bound")
        .hasMessageContaining("instant=" + lowerBound.toString())
        .hasMessageContaining("lowerBound=" + lowerBound.toString());
  }

  @Test
  public void test_validate_with_null_instant() throws Exception {
    // GIVEN
    Validator<Instant> validator = new GreaterThanValidator<>("instant", Instant.now());
    LOGGER.info("GIVEN - validator={}", validator);

    // WHEN & THEN
    assertThatThrownBy(() -> validator.validate(null))
        .isInstanceOf(ValidationException.class)
        .hasMessage("instant is null.");
  }
}
