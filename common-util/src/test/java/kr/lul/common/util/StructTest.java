package kr.lul.common.util;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.util.Map;

import static kr.lul.common.util.Collections.linkedMapOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2021/03/29
 */
class StructTest {
  private static final Logger LOGGER = getLogger(StructTest.class);

  @Test
  void test_new() {
    // WHEN
    Struct struct = new Struct();
    LOGGER.info("[WHEN] struct={}", struct);

    // THEN
    assertThat(struct.toMap())
        .isEmpty();
  }

  @Test
  void test_new_with_map() {
    // GIVEN
    Map<String, Object> properties = Map.of("a", 1);
    LOGGER.info("[GIVEN] properties={}", properties);

    // WHEN
    Struct struct = new Struct(properties);
    LOGGER.info("[WHEN] struct={}", struct);

    // THEN
    assertThat(struct.toMap())
        .hasSize(1)
        .containsEntry("a", 1);
  }

  @Test
  void test_toMap_with_prefix() {
    // GIVEN
    Map<String, Object> properties = linkedMapOf(
        "a1", 1,
        "a2", true,
        "b1", new Object());
    LOGGER.info("[GIVEN] properties={}", properties);

    Struct struct = new Struct(properties);
    LOGGER.info("[GIVEN] struct={}", struct);

    // WHEN
    Map<String, Object> actual = struct.toMap("a");
    LOGGER.info("[WHEN] actual={}", actual);

    // THEN
    assertThat(actual)
        .hasSize(2)
        .containsEntry("a1", 1)
        .containsEntry("a2", true);
  }

  @Test
  void test_toMap_with_predicate() {
    // GIVEN
    Map<String, Object> properties = linkedMapOf(
        "a1", 1,
        "a2", true,
        "b1", new Object());
    LOGGER.info("[GIVEN] properties={}", properties);

    Struct struct = new Struct(properties);
    LOGGER.info("[GIVEN] struct={}", struct);

    // WHEN
    Map<String, Object> actual = struct.toMap(entry -> entry.getKey().startsWith("a"));
    LOGGER.info("[WHEN] actual={}", actual);

    // THEN
    assertThat(actual)
        .hasSize(2)
        .containsEntry("a1", 1)
        .containsEntry("a2", true);
  }

  @Test
  void test_filter_with_prefix() {
    // GIVEN
    Map<String, Object> properties = linkedMapOf(
        "a1", 1,
        "a2", true,
        "b1", new Object());
    LOGGER.info("[GIVEN] properties={}", properties);

    Struct struct = new Struct(properties);
    LOGGER.info("[GIVEN] struct={}", struct);

    // WHEN
    Struct actual = struct.filter("a");
    LOGGER.info("[WHEN] actual={}", actual);

    // THEN
    assertThat(actual)
        .isNotNull()
        .isNotSameAs(struct)
        .extracting(Struct::size, Struct::isEmpty, Struct::isNotEmpty)
        .containsSequence(2, false, true);

    assertThat(actual.get("a1"))
        .isEqualTo(1);
    assertThat(actual.get("a2"))
        .isEqualTo(true);
  }

  @Test
  void test_filter_with_predicate() {
    // GIVEN
    Map<String, Object> properties = linkedMapOf(
        "a1", 1,
        "a2", true,
        "b1", new Object());
    LOGGER.info("[GIVEN] properties={}", properties);

    Struct struct = new Struct(properties);
    LOGGER.info("[GIVEN] struct={}", struct);

    // WHEN
    Struct actual = struct.filter(entry -> entry.getKey().startsWith("a"));
    LOGGER.info("[WHEN] actual={}", actual);

    // THEN
    assertThat(actual)
        .isNotNull()
        .isNotSameAs(struct)
        .extracting(Struct::size, Struct::isEmpty, Struct::isNotEmpty)
        .containsSequence(2, false, true);

    assertThat(actual.get("a1"))
        .isEqualTo(1);
    assertThat(actual.get("a2"))
        .isEqualTo(true);
  }

  @Test
  void test_filterKey_with_predicate() {
    // GIVEN
    Map<String, Object> properties = linkedMapOf(
        "a1", 1,
        "a2", true,
        "b1", new Object());
    LOGGER.info("[GIVEN] properties={}", properties);

    Struct struct = new Struct(properties);
    LOGGER.info("[GIVEN] struct={}", struct);

    // WHEN
    Struct actual = struct.filterKey(key -> key.startsWith("a"));
    LOGGER.info("[WHEN] actual={}", actual);

    // THEN
    assertThat(actual)
        .isNotNull()
        .isNotSameAs(struct)
        .extracting(Struct::size, Struct::isEmpty, Struct::isNotEmpty)
        .containsSequence(2, false, true);

    assertThat(actual.get("a1"))
        .isEqualTo(1);
    assertThat(actual.get("a2"))
        .isEqualTo(true);
  }

  @Test
  void test_subStruct_with_prefix() {
    // GIVEN
    Map<String, Object> properties = linkedMapOf(
        "a1", 1,
        "a2", true,
        "b1", new Object());
    LOGGER.info("[GIVEN] properties={}", properties);

    Struct struct = new Struct(properties);
    LOGGER.info("[GIVEN] struct={}", struct);

    // WHEN
    Struct actual = struct.subStruct("a");
    LOGGER.info("[WHEN] actual={}", actual);

    // THEN
    assertThat(actual)
        .isNotNull()
        .extracting(Struct::size, Struct::isEmpty, Struct::isNotEmpty)
        .containsSequence(2, false, true);

    assertThat(actual.toMap())
        .hasSize(2)
        .containsEntry("1", 1)
        .containsEntry("2", true);
  }
}
