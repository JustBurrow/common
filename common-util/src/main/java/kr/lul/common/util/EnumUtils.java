package kr.lul.common.util;

import java.util.concurrent.ThreadLocalRandom;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2021/08/01
 */
public abstract class EnumUtils {
  private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

  /**
   * {@code enum}이 정의한 값 중 임의의 값을 반환한다.
   *
   * @param type {@code enum} 타입.
   * @param <E>  {@code enum} 타입.
   *
   * @return 임의의 {@code enum}값.
   */
  public static <E extends Enum<?>> E random(Class<E> type) {
    E[] values = notNull(type, "type")
        .getEnumConstants();
    return values[RANDOM.nextInt(0, values.length)];
  }

  protected EnumUtils() {
    throw new UnsupportedOperationException();
  }
}