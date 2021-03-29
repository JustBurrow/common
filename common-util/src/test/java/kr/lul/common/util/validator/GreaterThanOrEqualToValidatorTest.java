package kr.lul.common.util.validator;

import kr.lul.common.util.ValidationException;
import kr.lul.common.util.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/11/16
 */
public class GreaterThanOrEqualToValidatorTest {
  private static final Logger log = getLogger(GreaterThanOrEqualToValidatorTest.class);

  private Instant lowerBound;
  private Validator<Instant> validator;

  @BeforeEach
  public void setUp() throws Exception {
    this.lowerBound = Instant.now();
    log.info("SETUP - lowerBound={}", this.lowerBound);
    this.validator = new GreaterThanOrEqualToValidator<>("instant", this.lowerBound);
    log.info("SETUP - validator={}", this.validator);
  }

  @Test
  public void test_validate_with_null_instant() throws Exception {
    assertThatThrownBy(() -> this.validator.validate(null))
        .isInstanceOf(ValidationException.class)
        .hasMessage("instant is null.");
  }

  @Test
  public void test_validate_with_same_instant() throws Exception {
    this.validator.validate(this.lowerBound);
  }

  @Test
  public void test_validate_with_equal_instant() throws Exception {
    // GIVEN
    Instant target = Instant.ofEpochSecond(this.lowerBound.getEpochSecond(), this.lowerBound.getNano());
    log.info("GIVEN - target={}", target);

    // WHEN
    this.validator.validate(target);
  }

  @Test
  public void test_validate_with_older_instant() throws Exception {
    // GIVEN
    Instant target = this.lowerBound.minusNanos(1L);
    log.info("GIVEN - target={}", target);

    // WHEN & THEN
    assertThatThrownBy(() -> this.validator.validate(target))
        .isInstanceOf(ValidationException.class)
        .hasMessageStartingWith("instant is not greater than or equal to lower bound")
        .hasMessageContaining("instant=" + target)
        .hasMessageContaining("lowerBound=" + this.lowerBound);
  }

  @Test
  public void test_validate_with_newer_instant() throws Exception {
    // GIVEN
    Instant target = this.lowerBound.plusNanos(1L);
    log.info("GIVEN - target={}", target);

    // WHEN
    this.validator.validate(target);
  }
}
