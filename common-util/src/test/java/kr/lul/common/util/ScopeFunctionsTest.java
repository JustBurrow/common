package kr.lul.common.util;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.util.function.Consumer;
import java.util.function.Function;

import static kr.lul.common.util.ScopeFunctions.*;
import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2021/03/28
 */
class ScopeFunctionsTest {
  private static final Logger LOGGER = getLogger(ScopeFunctionsTest.class);

  @Test
  void test_let_with_illegal_null() {
    assertThatThrownBy(() -> let(null, (Consumer<? extends Object>) null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("block is null.");

    assertThatThrownBy(() -> let(null, (Function<? extends Object, ? extends Object>) null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("block is null.");
  }

  @Test
  void test_let_with_null_and_consumer() {
    let(null, (Consumer<? extends Object>) obj -> {
    });
  }

  @Test
  void test_let_with_null_and_function() {
    assertThat((String) let(null, obj -> obj))
        .isNull();
  }

  class A {
    String text;
  }

  @Test
  void test_let_consumer() {
    // GIVEN
    A a = new A();
    String text = random(10);
    LOGGER.info("GIVEN - text={}", text);

    // WHEN
    let(text, str -> {
      a.text = str;
    });

    // THEN
    assertThat(a.text)
        .isEqualTo(text);
  }

  @Test
  void test_let_function() {
    // GIVEN
    A a = new A();
    String text = random(10);
    LOGGER.info("GIVEN - text={}", text);

    // WHEN
    String actual = let(text, str -> {
      a.text = str;
      return str + str;
    });
    LOGGER.info("[WHEN] actual={}", actual);

    // THEN
    assertThat(actual)
        .isNotEqualTo(text)
        .isEqualTo(text + text);
  }

  @Test
  void test_also_with_null() {
    assertThatThrownBy(() -> also(null, null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("block is null.");
  }

  @Test
  void test_also() {
    // GIVEN
    A a = new A();
    String text = random(10);
    LOGGER.info("[GIVEN] text={}", text);

    // WHEN
    String actual = also(text, it -> a.text = it + it);
    LOGGER.info("[WHEN] actual={}", actual);

    // THEN
    assertThat(actual)
        .isEqualTo(text);
    assertThat(a.text)
        .isNotNull()
        .isNotEqualTo(text)
        .isEqualTo(text + text);
  }

  @Test
  void test_with_null_block() {
    assertThatThrownBy(() -> with(null, null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("block is null.");
    assertThatThrownBy(() -> with("test", null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("block is null.");
  }
}
