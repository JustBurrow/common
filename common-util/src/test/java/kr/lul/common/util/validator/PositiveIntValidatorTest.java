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
 * @since 2021/06/02
 */
public class PositiveIntValidatorTest {
  private static final Logger LOGGER = getLogger(PositiveIntValidatorTest.class);

  private PositiveIntValidator validator;

  @BeforeEach
  void setUp() {
    this.validator = new PositiveIntValidator();
  }

  @Test
  void test_new_with_illegal_targetName() {
    assertThatThrownBy(() -> new PositiveIntValidator(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("targetName is null.");

    assertThatThrownBy(() -> new PositiveIntValidator(""))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("targetName is empty.");

    assertThatThrownBy(() -> new PositiveIntValidator(( " " )))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageStartingWith("targetName contains whitespace character(s) :");

    assertThatThrownBy(() -> new PositiveIntValidator(( " a" )))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageStartingWith("targetName contains whitespace character(s) :");

    assertThatThrownBy(() -> new PositiveIntValidator(( "a " )))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageStartingWith("targetName contains whitespace character(s) :");

    assertThatThrownBy(() -> new PositiveIntValidator(( " a " )))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageStartingWith("targetName contains whitespace character(s) :");

    assertThatThrownBy(() -> new PositiveIntValidator(( "a b" )))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageStartingWith("targetName contains whitespace character(s) :");
  }

  @Test
  void test_validate_with_int_negative_1() {
    assertThatThrownBy(() -> this.validator.validate(-1))
        .isInstanceOf(ValidationException.class)
        .hasMessage("number is not positive : -1")
        .extracting("targetName", "target")
        .containsSequence("number", -1);
  }

  @Test
  void test_validate_with_int_0() {
    assertThatThrownBy(() -> this.validator.validate(0))
        .isInstanceOf(ValidationException.class)
        .hasMessage("number is not positive : 0")
        .extracting("targetName", "target")
        .containsSequence("number", 0);
  }

  @Test
  void test_validate_with_int_1() {
    assertThat(this.validator.validate(1))
        .isSameAs(1);
  }

  @Test
  void test_validate_with_null() {
    assertThatThrownBy(() -> this.validator.validate(null))
        .isInstanceOf(ValidationException.class)
        .hasMessage("number is null.");
  }

  @Test
  void test_validate_with_Integer_negative_1() {
    // GIVEN
    Integer i = -1;

    // WHEN & THEN
    assertThatThrownBy(() -> this.validator.validate(i))
        .isInstanceOf(ValidationException.class)
        .hasMessage("number is not positive : -1")
        .extracting("targetName", "target")
        .containsSequence("number", i);
  }

  @Test
  void test_validate_with_Integer_0() {
    // GIVEN
    Integer i = 0;

    // WHEN & THEN
    assertThatThrownBy(() -> this.validator.validate(i))
        .isInstanceOf(ValidationException.class)
        .hasMessage("number is not positive : 0")
        .extracting("targetName", "target")
        .containsSequence("number", i);
  }

  @Test
  void test_validate_with_Integer_positive_1() {
    // GIVEN
    Integer i = 1;

    // WHEN & THEN
    assertThat(this.validator.validate(i))
        .isSameAs(i);
  }
}