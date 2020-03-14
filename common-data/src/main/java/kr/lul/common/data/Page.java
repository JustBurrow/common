package kr.lul.common.data;

import java.util.List;

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
}
