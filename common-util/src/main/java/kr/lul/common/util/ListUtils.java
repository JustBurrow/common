package kr.lul.common.util;

import java.util.List;

import static kr.lul.common.util.Arguments.notNull;

/**
 * {@link List} 유틸리티 메서드.
 *
 * @author justburrow
 * @since 2020/07/24
 */
public abstract class ListUtils {
  /**
   * 리스트의 서브 리스트를 반환한다.
   *
   * @param list      원본 리스트.
   * @param fromIndex 서브리스트의 시작 인덱스. 포함.
   * @param toIndex   서브리스트의 끝 인덱스. 미포함.
   * @param <E>       리스트 엘리먼트 타입.
   *
   * @return 서브리스트. {@code fromIndex == toIndex}이면 빈 리스트. {@code fromIndex}가 원본 리스트의 범위 밖이면 빈 리스트.
   *
   * @see List#subList(int, int)
   */
  public static <E> List<E> subList(final List<E> list, final int fromIndex, final int toIndex) {
    notNull(list, "list");

    return list.size() > fromIndex
               ? list.subList(fromIndex, Math.min(toIndex, list.size()))
               : List.of();
  }

  public ListUtils() {
    throw new UnsupportedOperationException();
  }
}
