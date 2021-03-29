package kr.lul.common.util;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static kr.lul.common.util.ExceptionTranslator.TryBlock;
import static kr.lul.common.util.ExceptionTranslator.translate;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2020/05/21
 */
public class ExceptionTranslatorTest {
  private static final Logger log = getLogger(ExceptionTranslatorTest.class);

  @Test
  public void test_translate_with_null_and_null() throws Exception {
    assertThatThrownBy(() -> translate(null, null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("tryBlock is null.");
  }

  @Test
  public void test_translate_with_null_runnable() throws Exception {
    assertThatThrownBy(() -> translate(null, RuntimeException::new))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("tryBlock is null.");
  }

  @Test
  public void test_translate_with_null_thrower() throws Exception {
    assertThatThrownBy(() -> translate(Exception::new, null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("thrower is null.");
  }

  @Test
  public void test_translate() throws Exception {
    // GIVEN
    final Exception cause = new Exception("cause");
    log.info("GIVEN - cause=" + cause);
    final TryBlock<Exception> tryBlock = () -> {
      throw cause;
    };

    // WHEN & THEN
    assertThatThrownBy(() -> translate(tryBlock, RuntimeException::new))
        .isInstanceOf(RuntimeException.class)
        .hasCause(cause);
  }

  @Test
  public void test_translate_with_ValidationException() throws Exception {
    // GIVEN
    final TryBlock<ValidationException> tryBlock = () -> {
      throw new ValidationException("test", null);
    };

    // WHEN & THEN
    assertThatThrownBy(() -> translate(tryBlock::doTry, RuntimeException::new))
        .isInstanceOf(RuntimeException.class)
        .hasCauseInstanceOf(ValidationException.class);
  }
}
