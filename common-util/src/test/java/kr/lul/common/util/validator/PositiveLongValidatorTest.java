package kr.lul.common.util.validator;

import kr.lul.common.util.ValidationException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/11/16
 */
public class PositiveLongValidatorTest {
  private static final Logger log = getLogger(PositiveLongValidatorTest.class);

  private PositiveLongValidator validator;

  @Before
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
