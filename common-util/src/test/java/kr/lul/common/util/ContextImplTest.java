package kr.lul.common.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.time.Instant;
import java.time.temporal.Temporal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2021/09/09
 */
class ContextImplTest {
  private static final Logger LOGGER = getLogger(ContextImplTest.class);

  private Context context;

  @BeforeEach
  void setUp() {
    this.context = new ContextImpl();
    LOGGER.info("[SETUP] context={}", this.context);
  }

  @Test
  void test_new() {
    // WHEN
    Context ctx = new ContextImpl();
    LOGGER.info("[WHEN] ctx={}", ctx);

    // THEN
    assertThat(ctx.size())
        .isEqualTo(0);
  }

  @Test
  void test_put_with_simple_key() {
    // GIVEN
    String key = "a";
    Object obj = new Object();
    LOGGER.info("[GIVEN] key={}, obj={}", key, obj);

    // WHEN
    Object actual = this.context.put(key, obj);
    LOGGER.info("[WHEN] actual={}", actual);

    // THEN
    assertThat(actual).isNull();
    assertThat(this.context.get(key))
        .isSameAs(obj);
    assertThat(this.context.size())
        .isEqualTo(1);
  }

  @Test
  void test_get_with_type() {
    // GIVEN
    String key = "a";
    Instant obj = Instant.now();
    LOGGER.info("[GIVEN] key={}, obj={}", key, obj);

    this.context.put(key, obj);
    LOGGER.info("[GIVEN] context={}", this.context);

    // WHEN
    Instant actual1 = this.context.get(key, Instant.class);
    Temporal actual2 = this.context.get(key, Temporal.class);
    LOGGER.info("[WHEN] actual1={}, actual2={}", actual1, actual2);

    // THEN
    assertThat(actual1)
        .isSameAs(obj);
    assertThat(actual2)
        .isSameAs(obj);
  }

  @Test
  void test_get_with_illegal_type() {
    // GIVEN
    this.context.put("key", Instant.now());
    LOGGER.info("[GIVEN] context={}", this.context);

    // WHEN & THEN
    assertThatThrownBy(() -> this.context.get("key", String.class))
        .isInstanceOf(ClassCastException.class);
  }

  @Test
  void test_remove() {
    // GIVEN
    Instant obj = Instant.now();
    this.context.put("key", obj);
    LOGGER.info("[GIVEN] context={}", this.context);

    // WHEN
    Object actual = this.context.remove("key");
    LOGGER.info("[WHEN] actual={}", actual);

    // THEN
    assertThat(this.context.size())
        .isEqualTo(0);
    assertThat(actual)
        .isSameAs(obj);
  }
}