package kr.lul.common.util.validator;

import kr.lul.common.util.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/11/16
 */
public class PositiveLongValidatorTest {
  private static final Logger log = getLogger(PositiveLongValidatorTest.class);

  private PositiveLongValidator validator;

  @BeforeEach
  public void setUp() throws Exception {
    this.validator = new PositiveLongValidator();
  }

  @Test
  public void test_validate_with_0L() throws Exception {
    assertThatThrownBy(() -> this.validator.validate(0L))
        .isInstanceOf(ValidationException.class)
        .hasMessageContaining("is not positive");
  }

  @Test
  public void test_validate_with_negative_1L() throws Exception {
    assertThatThrownBy(() -> this.validator.validate(-1L))
        .isInstanceOf(ValidationException.class)
        .hasMessageContaining("is not positive");
  }

  @Test
  public void test_validate_with_positive_1L() {
    // WHEN
    assertThat(this.validator.validate(1L))
        .isEqualTo(1L);
  }

  @Test
  void test_validate_with_0() {
    assertThatThrownBy(() -> this.validator.validate(Long.valueOf(0L)))
        .isInstanceOf(ValidationException.class)
        .hasMessage("number is not positive : 0");
  }

  @Test
  void test_validate_with_negative_1() {
    assertThatThrownBy(() -> this.validator.validate(Long.valueOf(-1L)))
        .isInstanceOf(ValidationException.class)
        .hasMessage("number is not positive : -1");
  }

  @Test
  void test_validate_with_1() {
    // GIVEN
    Long l = 1L;

    // WHEN & THEN
    assertThat(this.validator.validate(l))
        .isSameAs(l);
  }

  @Test
  public void test_validate_with_null() throws Exception {
    assertThatThrownBy(() -> this.validator.validate(null))
        .isInstanceOf(ValidationException.class)
        .hasMessageEndingWith("is null.");
  }

  @Test
  public void test_validate_with_0_Long() throws Exception {
    assertThatThrownBy(() -> this.validator.validate(Long.valueOf(0L)))
        .isInstanceOf(ValidationException.class)
        .hasMessageContaining("is not positive");
  }

  @Test
  public void test_validate_with_negative_1_Long() throws Exception {
    assertThatThrownBy(() -> this.validator.validate(Long.valueOf(-1L)))
        .isInstanceOf(ValidationException.class)
        .hasMessageContaining("is not positive");
  }
}
