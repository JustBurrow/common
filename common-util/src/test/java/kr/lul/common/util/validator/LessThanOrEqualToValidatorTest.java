package kr.lul.common.util.validator;

import kr.lul.common.util.ValidationException;
import kr.lul.common.util.Validator;
import org.junit.jupiter.api.BeforeEach;
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
public class LessThanOrEqualToValidatorTest {
  private static final Logger LOGGER = getLogger(LessThanOrEqualToValidatorTest.class);

  private Instant upperBound;
  private Validator<Instant> validator;

  @BeforeEach
  public void setUp() throws Exception {
    this.upperBound = Instant.now();
    LOGGER.info("SETUP - upperBound={}", this.upperBound);
    this.validator = new LessThanOrEqualToValidator<>("instant", this.upperBound);
    LOGGER.info("SETUP - validator={}", this.validator);
  }

  @Test
  public void test_validate_with_null_instant() throws Exception {
    assertThatThrownBy(() -> this.validator.validate(null))
        .isInstanceOf(ValidationException.class)
        .hasMessage("instant is null.");
  }

  @Test
  public void test_validate_with_older_instant() throws Exception {
    // GIVEN
    Instant given = this.upperBound.minusNanos(1L);
    LOGGER.info("[GIVEN] given={}", given);

    // WHEN
    Instant actual = this.validator.validate(given);
    LOGGER.info("[WHEN] actual={}", actual);

    // THEN
    assertThat(actual)
        .isSameAs(given);
  }

  @Test
  public void test_validate_with_same_instant() throws Exception {
    // WHEN
    Instant actual = this.validator.validate(this.upperBound);
    LOGGER.info("[WHEN] actual={}", actual);

    // THEN
    assertThat(actual)
        .isSameAs(this.upperBound);
  }

  @Test
  public void test_validate_with_equal_instant() throws Exception {
    // GIVEN
    Instant target = Instant.ofEpochSecond(this.upperBound.getEpochSecond(), this.upperBound.getNano());
    LOGGER.info("GIVEN - target={}", target);

    // WHEN
    Instant actual = this.validator.validate(target);
    LOGGER.info("[WHEN] actual={}", actual);

    // THEN
    assertThat(actual)
        .isSameAs(target);
  }

  @Test
  public void test_validate_with_newer_instant() throws Exception {
    // GIVEN
    Instant target = this.upperBound.plusNanos(1L);
    LOGGER.info("GIVEN - target={}", target);

    // WHEN & THEN
    assertThatThrownBy(() -> this.validator.validate(target))
        .isInstanceOf(ValidationException.class)
        .hasMessageStartingWith("instant is not less than or equal to upper bound")
        .hasMessageContaining("instant=" + target)
        .hasMessageContaining("upperBound=" + this.upperBound);
  }
}
