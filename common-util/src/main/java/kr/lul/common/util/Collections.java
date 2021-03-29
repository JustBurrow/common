package kr.lul.common.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2021/03/29
 */
@SuppressWarnings("DuplicatedCode")
public abstract class Collections {
  public static <K, V> Map<K, V> linkedMapOf(K k1, V v1) {
    Map<K, V> map = new LinkedHashMap<>();
    map.put(k1, v1);
    return java.util.Collections.unmodifiableMap(map);
  }

  public static <K, V> Map<K, V> linkedMapOf(K k1, V v1, K k2, V v2) {
    Map<K, V> map = new LinkedHashMap<>();
    map.put(k1, v1);
    map.put(k2, v2);
    return java.util.Collections.unmodifiableMap(map);
  }

  public static <K, V> Map<K, V> linkedMapOf(K k1, V v1, K k2, V v2, K k3, V v3) {
    Map<K, V> map = new LinkedHashMap<>();
    map.put(k1, v1);
    map.put(k2, v2);
    map.put(k3, v3);
    return java.util.Collections.unmodifiableMap(map);
  }

  public static <K, V> Map<K, V> linkedMapOf(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
    Map<K, V> map = new LinkedHashMap<>();
    map.put(k1, v1);
    map.put(k2, v2);
    map.put(k3, v3);
    map.put(k4, v4);
    return java.util.Collections.unmodifiableMap(map);
  }

  public static <K, V> Map<K, V> linkedMapOf(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
    Map<K, V> map = new LinkedHashMap<>();
    map.put(k1, v1);
    map.put(k2, v2);
    map.put(k3, v3);
    map.put(k4, v4);
    map.put(k5, v5);
    return java.util.Collections.unmodifiableMap(map);
  }

  public static <K, V> Map<K, V> linkedMapOf(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
    Map<K, V> map = new LinkedHashMap<>();
    map.put(k1, v1);
    map.put(k2, v2);
    map.put(k3, v3);
    map.put(k4, v4);
    map.put(k5, v5);
    map.put(k6, v6);
    return java.util.Collections.unmodifiableMap(map);
  }

  public static <K, V> Map<K, V> linkedMapOf(Map.Entry<K, V>... entries) {
    Map<K, V> map = new HashMap<>();
    for (Map.Entry<K, V> entry : notNull(entries, "entries")) {
      map.put(entry.getKey(), entry.getValue());
    }
    return java.util.Collections.unmodifiableMap(map);
  }

  public Collections() {
    throw new UnsupportedOperationException();
  }
}
