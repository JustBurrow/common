package kr.lul.common.util;

import java.util.Map;
import java.util.regex.Pattern;

import static java.lang.String.format;

/**
 * 인스턴스 전달용 범용 자료구조.
 *
 * 인스턴스 여러개를 전달해야 하지만, 경우의 수가 많아 오버로딩을 사용할 수 없을 때 사용.
 *
 * @author justburrow
 * @since 2021/09/09
 */
public interface Context {
  char KEY_DELIMITER = '.';

  String KEY_REGEX = "^[^.,\\s]+(\\.[^.,\\s]+)*$";

  Pattern KEY_PATTERN = Pattern.compile(KEY_REGEX);

  Validator<String> KEY_VALIDATOR = key -> {
    final String message;
    if (null == key)
      message = "key is null.";
    else if (key.isEmpty())
      message = "key is empty.";
    else if (!key.matches(KEY_REGEX))
      message = format("illegal key : key=%s, regex=%s", key, KEY_REGEX);
    else
      return key;

    throw new ValidationException("key", key, message);
  };

  /**
   * @return 키 갯수.
   */
  int size();

  boolean isEmpty();

  /**
   * 새 키-값 추가.
   *
   * @param key   키.
   * @param value 값.
   *
   * @throws IllegalArgumentException 이미 사용중인 키.
   */
  void put(String key, Object value) throws IllegalArgumentException;

  /**
   * 인스턴스 찾기.
   *
   * @param key 키.
   *
   * @return 값.
   */
  Object get(String key);

  /**
   * 키-값 찾기.
   *
   * @param key  키.
   * @param type 값 타입.
   * @param <V>  값 타입.
   *
   * @return 값.
   */
  default <V> V get(String key, Class<V> type) {
    if (null == type)
      throw new IllegalArgumentException("type is null.");
    return type.cast(get(key));
  }

  /**
   * 키-값 제거.
   *
   * @param key 키.
   *
   * @return 제거한 값.
   */
  Object remove(String key);

  /**
   * 컨텍스트를 {@link Map}으로 변환.
   *
   * @return 컨텍스트의 값을 가진 맵.
   */
  Map<String, Object> toMap();
}