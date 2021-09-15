package kr.lul.common.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.time.Instant;
import java.time.temporal.Temporal;
import java.util.Map;

import static java.time.Instant.now;
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
    Object value = new Object();
    LOGGER.info("[GIVEN] key={}, value={}", key, value);

    // WHEN
    this.context.put(key, value);

    // THEN
    assertThat(this.context.get(key))
        .isSameAs(value);
    assertThat(this.context.size())
        .isEqualTo(1);
  }

  @Test
  void test_put_with_illegal_key() {
    assertThatThrownBy(() -> this.context.put(null, null))
        .isInstanceOf(ValidationException.class);
    assertThatThrownBy(() -> this.context.put(" ", new Object()))
        .isInstanceOf(ValidationException.class);
    assertThatThrownBy(() -> this.context.put(".a", new Object()))
        .isInstanceOf(ValidationException.class);
    assertThatThrownBy(() -> this.context.put("a.", new Object()))
        .isInstanceOf(ValidationException.class);
    assertThatThrownBy(() -> this.context.put("a. b", new Object()))
        .isInstanceOf(ValidationException.class);
    assertThatThrownBy(() -> this.context.put("a,b", new Object()))
        .isInstanceOf(ValidationException.class);
  }

  @Test
  void test_get_with_type() {
    // GIVEN
    String key = "a";
    Instant value = now();
    LOGGER.info("[GIVEN] key={}, value={}", key, value);

    this.context.put(key, value);
    LOGGER.info("[GIVEN] context={}", this.context);

    // WHEN
    Instant actual1 = this.context.get(key, Instant.class);
    Temporal actual2 = this.context.get(key, Temporal.class);
    LOGGER.info("[WHEN] actual1={}, actual2={}", actual1, actual2);

    // THEN
    assertThat(actual1)
        .isSameAs(value);
    assertThat(actual2)
        .isSameAs(value);
  }

  @Test
  void test_get_parent() {
    // GIVEN
    String key = "parent.child";
    Instant value = now();
    this.context.put(key, value);
    LOGGER.info("[GIVEN] context={}", this.context);

    // WHEN
    Context parent = (Context) this.context.get("parent");
    LOGGER.info("[WHEN] parent={}", parent);

    // THEN
    assertThat(parent.size())
        .isEqualTo(1);
    assertThat(parent.get("child"))
        .isSameAs(value);
  }

  @Test
  void test_get_for_null() {
    // GIVEN
    String k1 = "a.b1.c";
    String k2 = "a.b1.d";
    String k3 = "a.b2";
    this.context.put(k1, now());
    this.context.put(k2, now());
    this.context.put(k3, null);
    LOGGER.info("[GIVEN] context={}", this.context);

    // WHEN
    Object v3 = this.context.get(k3);
    LOGGER.info("[WHEN] v3={}", v3);

    // THEN
    assertThat(v3).isNull();
  }

  @Test
  void test_get_with_null_type() {
    assertThatThrownBy(() -> this.context.get("a", null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("type is null.");
  }

  @Test
  void test_get_with_illegal_type() {
    // GIVEN
    this.context.put("key", now());
    LOGGER.info("[GIVEN] context={}", this.context);

    // WHEN & THEN
    assertThatThrownBy(() -> this.context.get("key", String.class))
        .isInstanceOf(ClassCastException.class);
  }

  @Test
  void test_remove() {
    // GIVEN
    Instant obj = now();
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

  @Test
  void test_size_with_tree() {
    // GIVEN
    String key1 = "a.b1.c1";
    Instant val1 = now();
    String key2 = "a.b1.c2";
    Instant val2 = now();
    String key3 = "a.b2.c3";
    Instant val3 = now();

    this.context.put(key1, val1);
    this.context.put(key2, val2);
    this.context.put(key3, val3);
    LOGGER.info("[GIVEN] context={}", this.context);

    // WHEN
    int size = this.context.size();
    LOGGER.info("[WHEN] size={}", size);

    // THEN
    assertThat(size)
        .isEqualTo(3);
  }

  @Test
  void test_toMap_with_empty() {
    // WHEN
    Map<String, Object> map = this.context.toMap();
    LOGGER.info("[WHEN] map={}", map);

    // THEN
    assertThat(map)
        .isEmpty();
  }

  @Test
  void test_toMap() {
    // GIVEN
    String key1 = "a.b1.c1";
    Instant val1 = now();
    String key2 = "a.b1.c2";
    Instant val2 = now();
    String key3 = "a.b2.c3";
    Instant val3 = now();
    String key4 = "a.b3";
    Instant val4 = now();

    this.context.put(key1, val1);
    this.context.put(key2, val2);
    this.context.put(key3, val3);
    this.context.put(key4, val4);
    LOGGER.info("[GIVEN] context={}", this.context);

    // WHEN
    Map<String, Object> map = this.context.toMap();
    LOGGER.info("[WHEN] map={}", map);

    // THEN
    assertThat(map)
        .hasSize(4)
        .containsOnlyKeys(key1, key2, key3, key4);
    assertThat(map.get(key1))
        .isSameAs(val1);
    assertThat(map.get(key2))
        .isSameAs(val2);
    assertThat(map.get(key3))
        .isSameAs(val3);
    assertThat(map.get(key4))
        .isSameAs(val4);
  }
}