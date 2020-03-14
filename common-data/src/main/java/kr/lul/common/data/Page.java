package kr.lul.common.data;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;
import static kr.lul.common.util.Arguments.notNull;

/**
 * {@code org.springframework.data.domain.Slice} 대체 인터페이스.
 *
 * @param <T> 데이터 타입.
 *
 * @author justburrow
 * @since 2020/03/14
 */
public interface Page<T> {
  /**
   * @return 현재 페이지. 0-based.
   */
  int getPage();

  /**
   * @return 현재 페이지의 데이터 수.
   */
  default int getCount() {
    return getContent().size();
  }

  /**
   * @return 한 페이지의 최대 데이터 수.
   */
  int getLimit();

  /**
   * @return 현재 페이지의 데이터.
   */
  List<T> getContent();

  /**
   * @return 전체 페이지 수.
   */
  default int getTotalPage() {
    long page = getTotalCount() / getLimit();
    if (0 < getTotalCount() % getLimit())
      page++;
    return (int) page;
  }

  /**
   * @return 전체 데이터 수.
   */
  long getTotalCount();

  /**
   * @return 첫 페이지이면 {@code true}.
   */
  default boolean isFirst() {
    return 0 == getPage();
  }

  /**
   * @return 마지막 페이지이면 {@code true}.
   */
  default boolean isLast() {
    return getPage() == getTotalPage() - 1;
  }

  /**
   * @return 앞 페이지가 있으면 {@code true}.
   */
  default boolean hasBefore() {
    return 0 < getPage();
  }

  /**
   * @return 다음 페이지가 있으면 {@code true}.
   */
  default boolean hasNext() {
    return getPage() < getTotalPage() - 1;
  }

  /**
   * 자료형 변환한 인스턴스를 반환한다.
   *
   * @param converter 자료형 변환 함수.
   * @param <R>       타겟 자료형.
   *
   * @return 자료형이 변환된 인스턴스.
   */
  default <R> Page<R> map(final Function<? super T, ? extends R> converter) {
    notNull(converter, "converter");
    return new Pagination<>(getPage(), getLimit(), getTotalCount(), getContent().stream().map(converter).collect(toList()));
  }
}
