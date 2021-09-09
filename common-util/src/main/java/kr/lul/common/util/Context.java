package kr.lul.common.util;

import java.util.Map;
import java.util.regex.Pattern;

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
  String KEY_REGEX = "^[^.\\n\\r]+(\\.[^.\\n\\r]+)*$";
  Pattern KEY_PATTERN = Pattern.compile(KEY_REGEX);

  /**
   * @return 키 갯수.
   */
  int size();

  /**
   * 새 인스턴스 추가.
   *
   * @param key 키.
   * @param obj 인스턴스.
   *
   * @return 기존 값. 없으면 {@code null}.
   */
  Object put(String key, Object obj);

  /**
   * 인스턴스 찾기.
   *
   * @param key 키.
   *
   * @return 인스턴스.
   */
  Object get(String key);

  /**
   * 인스턴스 찾기.
   *
   * @param key  키.
   * @param type 인스턴스 타입.
   * @param <V>  인스턴스 타입.
   *
   * @return 인스턴스.
   */
  @SuppressWarnings("unchecked")
  default <V> V get(String key, Class<V> type) {
    return (V) get(key);
  }

  /**
   * 인스턴스 제거.
   *
   * @param key 키.
   *
   * @return 제거한 인스턴스.
   */
  Object remove(String key);

  /**
   * 컨텍스트를 {@link Map}으로 변환.
   *
   * @return 컨텍스트의 값을 가진 맵.
   */
  Map<String, Object> toMap();
}