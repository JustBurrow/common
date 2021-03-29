package kr.lul.common.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

import static java.lang.String.format;
import static java.util.Collections.unmodifiableMap;
import static java.util.stream.Collectors.toUnmodifiableMap;
import static kr.lul.common.util.Arguments.notEmpty;
import static kr.lul.common.util.Arguments.notNull;

/**
 * 범용 데이터 교환용 자료구조.
 *
 * <b>덮어쓰기 불가, thread safe 아님.</b>
 *
 * @author justburrow
 * @since 2021/03/29
 */
public class Struct {
  private final Map<String, Object> properties;

  public Struct() {
    this.properties = new LinkedHashMap<>();
  }

  /**
   * @param properties 초기 설정.
   */
  public Struct(Map<String, Object> properties) {
    this();
    this.properties.putAll(properties);
  }

  public Struct(Struct struct) {
    this();
    this.properties.putAll(notNull(struct, "context")
                               .toMap());
  }

  public int size() {
    return this.properties.size();
  }

  public boolean isEmpty() {
    return this.properties.isEmpty();
  }

  public boolean isNotEmpty() {
    return !this.properties.isEmpty();
  }

  /**
   * @param key   속성 이름. non-null, non-empty.
   * @param value 값.
   */
  public void put(String key, Object value) {
    notEmpty(key);

    if (this.properties.containsKey(key))
      throw new IllegalStateException(
          format("already registered property : key=%s, value=%s, currentValue=%s", key, value, this.properties.get(key)));

    this.properties.put(key, value);
  }

  /**
   * @param key 속성 이름. non-null, non-empty.
   *
   * @return 등록된 속성이면 {@code true}
   */
  public boolean hasKey(String key) {
    return this.properties.containsKey(notEmpty(key));
  }

  /**
   * @param key 속성 이름. non-null, non-empty.
   *
   * @return 키에 해당하는 값.
   */
  public Object get(String key) {
    if (this.properties.containsKey(notEmpty(key)))
      return this.properties.get(key);
    else
      throw new IllegalArgumentException("not registered key : key=" + key);
  }

  public <T> T get(String key, Class<T> clazz) {
    notNull(clazz, "clazz");
    //noinspection unchecked
    return (T) get(key);
  }

  /**
   * @return 등록된 속성.
   */
  public Map<String, Object> toMap() {
    return unmodifiableMap(this.properties);
  }

  /**
   * @param prefix 찾으려는 속성 이름의 접두어.
   *
   * @return 접두어로 시작하는 속성.
   */
  public Map<String, Object> toMap(String prefix) {
    return this.properties.entrySet()
               .stream()
               .filter(entry -> entry.getKey().startsWith(notNull(prefix, "prefix")))
               .collect(toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  /**
   * @param predicate 찾으려는 속성 조건.
   *
   * @return 조건에 맞는 속성.
   */
  public Map<String, Object> toMap(Predicate<Map.Entry<String, Object>> predicate) {
    return this.properties.entrySet()
               .stream()
               .filter(notNull(predicate, "predicate"))
               .collect(toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  /**
   * 필요한 속성으로 새 스트럭트를 만든다.
   *
   * @param prefix 찾으려는 속성 이름의 접두어.
   *
   * @return 새 스트럭트.
   */
  public Struct filter(String prefix) {
    return new Struct(toMap(prefix));
  }

  /**
   * 필요한 속성으로 새 스트럭트를 만든다.
   *
   * @param predicate 찾으려는 속성 조건.
   *
   * @return 새 스트럭트.
   */
  public Struct filter(Predicate<Map.Entry<String, Object>> predicate) {
    return new Struct(toMap(predicate));
  }

  public Struct filterKey(Predicate<String> predicate) {
    notNull(predicate, "predicate");
    return new Struct(
        this.properties.entrySet().stream()
            .filter(entry -> predicate.test(entry.getKey()))
            .collect(toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue)));
  }

  public Struct subStruct(String prefix) {
    notNull(prefix, "prefix");

    int startIndex = prefix.length();
    return 0 == startIndex
               ? new Struct(toMap())
               : new Struct(this.properties.entrySet()
                                .stream()
                                .filter(entry -> entry.getKey().startsWith(prefix))
                                .collect(toUnmodifiableMap(e -> e.getKey().substring(startIndex), Map.Entry::getValue)));
  }

  @Override
  public String toString() {
    return this.properties.toString();
  }
}
