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
public class LessThanOrEqualToValidatorTest {
  private static final Logger log = getLogger(LessThanOrEqualToValidatorTest.class);

  private Instant upperBound;
  private Validator<Instant> validator;

  @BeforeEach
  public void setUp() throws Exception {
    this.upperBound = Instant.now();
    log.info("SETUP - upperBound={}", this.upperBound);
    this.validator = new LessThanOrEqualToValidator<>("instant", this.upperBound);
    log.info("SETUP - validator={}", this.validator);
  }

  @Test
  public void test_validate_with_null_instant() throws Exception {
    assertThatThrownBy(() -> this.validator.validate(null))
        .isInstanceOf(ValidationException.class)
        .hasMessage("instant is null.");
  }

  @Test
  public void test_validate_with_older_instant() throws Exception {
    this.validator.validate(this.upperBound.minusNanos(1L));
  }

  @Test
  public void test_validate_with_same_instant() throws Exception {
    this.validator.validate(this.upperBound);
  }

  @Test
  public void test_validate_with_equal_instant() throws Exception {
    // GIVEN
    Instant target = Instant.ofEpochSecond(this.upperBound.getEpochSecond(), this.upperBound.getNano());
    log.info("GIVEN - target={}", target);

    // WHEN
    this.validator.validate(target);
  }

  @Test
  public void test_validate_with_newer_instant() throws Exception {
    // GIVEN
    Instant target = this.upperBound.plusNanos(1L);
    log.info("GIVEN - target={}", target);

    // WHEN & THEN
    assertThatThrownBy(() -> this.validator.validate(target))
        .isInstanceOf(ValidationException.class)
        .hasMessageStartingWith("instant is not less than or equal to upper bound")
        .hasMessageContaining("instant=" + target)
        .hasMessageContaining("upperBound=" + this.upperBound);
  }
}
