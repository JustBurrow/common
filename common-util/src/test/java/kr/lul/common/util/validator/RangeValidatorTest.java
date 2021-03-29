package kr.lul.common.util.validator;

import kr.lul.common.util.ContinuousRange;
import kr.lul.common.util.Range;
import kr.lul.common.util.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/11/19
 */
public class RangeValidatorTest {
  private static final Logger log = getLogger(RangeValidatorTest.class);

  private int min = 0;
  private int max = 10;
  private Range<Integer> range;
  private RangeValidator<Integer> validator;

  @BeforeEach
  public void setUp() throws Exception {
    this.range = new ContinuousRange<>(this.min, this.max);
    log.info("SETUP - range={}", this.range);
    this.validator = new RangeValidator<>("number", this.range);
    log.info("SETUP - validator={}", this.validator);
  }

  @Test
  public void test_validate_with_null() throws Exception {
    assertThatThrownBy(() -> this.validator.validate(null))
        .isInstanceOf(ValidationException.class)
        .hasCauseInstanceOf(IllegalArgumentException.class)
        .extracting("targetName", "target")
        .containsSequence("number", null);
  }

  @Test
  public void test_validate_with_min_minus_1() throws Exception {
    assertThatThrownBy(() -> this.validator.validate(this.min - 1))
        .isInstanceOf(ValidationException.class)
        .hasNoCause()
        .hasMessageStartingWith("number is out of range")
        .hasMessageContaining("number=" + (this.min - 1))
        .hasMessageContaining("range=" + this.range)
        .extracting("targetName", "target")
        .containsSequence("number", this.min - 1);
  }

  @Test
  public void test_validate_with_min() throws Exception {
    this.validator.validate(this.min);
  }

  @Test
  public void test_validate_with_max() throws Exception {
    assertThatThrownBy(() -> this.validator.validate(this.max))
        .isInstanceOf(ValidationException.class)
        .hasNoCause()
        .hasMessageStartingWith("number is out of range")
        .hasMessageContaining("number=" + this.max)
        .hasMessageContaining("range=" + this.range)
        .extracting("targetName", "target")
        .containsSequence("number", this.max);
  }

  @Test
  public void test_validate_with_max_plus_1() throws Exception {
    assertThatThrownBy(() -> this.validator.validate(this.max + 1))
        .isInstanceOf(ValidationException.class)
        .hasNoCause()
        .hasMessageStartingWith("number is out of range")
        .hasMessageContaining("number=" + (this.max + 1))
        .hasMessageContaining("range=" + this.range)
        .extracting("targetName", "target")
        .containsSequence("number", this.max + 1);
  }
}
